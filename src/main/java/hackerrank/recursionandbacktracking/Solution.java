package hackerrank.recursionandbacktracking;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {

    public static void main(String[] args) {

        Solution sut = new Solution();
        CrossWordGraph graph = sut.new CrossWordGraph();
        List<String> lines = new ArrayList<>();

        try (final Scanner s = new Scanner(System.in)) {

            int counter = 11;

            while (--counter >= 0 && s.hasNextLine()) {
                String line = s.nextLine();
                if (line.length() == 0)
                    break;
                lines.add(line);
            }
        }

        if (lines.isEmpty()) {
            return;
        }

        String places = lines.remove(lines.size() - 1);

        Set<String> allWords = Stream.of(places.split(";")).collect(Collectors.toSet());

        CrossWordGrid grid = sut.new CrossWordGrid();

        for (int row = 0; row < lines.size(); row++) {
            String line = lines.get(row);
            for (int charAt = 0; charAt < line.length(); charAt++) {
                char c = line.charAt(charAt);
                if (c == '-') {
                    grid.grid[row][charAt] = c;
                }
            }
        }

        grid.produceGraph(graph);
//        System.out.println(graph.nodes.size());
//        System.out.println(graph.nodes);
        sut.recursive(graph, new HashMap<>(), allWords);
        grid.print(graph);
    }

    private void recursive(final CrossWordGraph graph, final Map<CellNode, Character> crossCheck, final Set<String> remainingWords) {

        for (final String w : remainingWords) {
            for (int index = 0; index < graph.nodes.size(); index++) {
                if (graph.excludeIndexes.contains(index)) {
                    continue;
                }

                final CellNode cellNode = graph.nodes.get(index);
                final HashMap<CellNode, Character> crossLetterCheck = new HashMap<>(crossCheck);
                if (cellNode.accept(w, crossLetterCheck)) {

                    final HashSet<String> newRemaining = new HashSet<>(remainingWords);
                    // remove this word and pass remaining
                    newRemaining.remove(w);
                    graph.excludeIndexes.add(index);

                    if (!graph.isComplete && newRemaining.isEmpty()) {
                        graph.isComplete = true;
                        return;
                    }

                    recursive(graph, crossLetterCheck, newRemaining);

                    if (graph.isComplete) {
                        return;
                    }
                    graph.excludeIndexes.remove(index);
                }
            }
        }
    }

    // Represents crossword puzzle matrix
    // this one is used to print
    private class CrossWordGrid {

        private char[][] grid = new char[10][10];
        // initialize with pluses '+'

        public CrossWordGrid() {
            for (int r = 0; r < grid.length; r++) {
                Arrays.fill(grid[r], '+');
            }
        }

        public void print(final CrossWordGraph from) {
            from.nodes.forEach(n -> n.visit((vn) -> grid[vn.row][vn.column] = vn.letter));
            for (int r = 0; r < grid.length; r++) {
                System.out.println(grid[r]);
            }
        }

        public void produceGraph(final CrossWordGraph graph) {
            List<CellNode> nodes = new ArrayList<>();
            for (int r = 0; r < grid.length; r++) {
                buildGraphRowsRecursively(null, r, nodes, 0, grid[r]);
            }
            for (int c = 0; c < 10; c++) {
                buildGraphColumnsRecursively(0, c, nodes, null);
            }

            graph.nodes = nodes;
        }

        private void buildGraphColumnsRecursively(int r, int c, List<CellNode> acc, CellNode current) {
            if (r < 10) {
                if (grid[r][c] == '-' && isAboveOrBelowMinus(r, c)) {
                    if (current == null) {
                        current = new CellNode(r, c, null);
                        acc.add(current);
                        current.isCrossLetter = isLeftOrRightMinus(r, c);
                    } else {
                        current.link = new CellNode(r, c, null);
                        current.link.isCrossLetter = isLeftOrRightMinus(r, c);
                    }
                    buildGraphColumnsRecursively(r + 1, c, acc, current.hasNextLink() ? current.link : current);
                } else {
                    buildGraphColumnsRecursively(r + 1, c, acc, null);
                }
            }
        }

        private void buildGraphRowsRecursively(CellNode current, int r, List<CellNode> acc, int column, char[] row) {
            if (column < row.length) {
                // can't be one '-'
                if (row[column] == '-' && isLeftOrRightMinus(r, column)) {
                    if (current == null) {
                        current = new CellNode(r, column, null);
                        acc.add(current);
                        current.isCrossLetter = isAboveOrBelowMinus(r, column);
                    } else {
                        current.link = new CellNode(r, column, null);
                        current.link.isCrossLetter = isAboveOrBelowMinus(r, column);
                    }
                    buildGraphRowsRecursively(current.hasNextLink() ? current.link : current, r, acc, column + 1, row);
                } else {
                    buildGraphRowsRecursively(null, r, acc, column + 1, row);
                }
            }
        }

        private boolean isAboveOrBelowMinus(int r, int c) {
            boolean result = false;
            if ((r - 1) >= 0) {
                // look up
                result |= grid[r - 1][c] == '-';
            }
            if ((r + 1) < grid.length) {
                result |= grid[r + 1][c] == '-';
            }
            return result;
        }

        private boolean isLeftOrRightMinus(int r, int c) {
            boolean result = false;
            if ((c - 1) >= 0) {
                // look up
                result |= grid[r][c - 1] == '-';
            }
            if ((c + 1) < grid.length) {
                result |= grid[r][c + 1] == '-';
            }
            return result;
        }
    }

    // Represents all place holder sequencies as nodes
    private class CrossWordGraph {
        public boolean isComplete = false;
        private List<CellNode> nodes = new ArrayList<>();
        private Set<Integer> excludeIndexes = new HashSet<>();
    }

    private static class CellNode {
        /* row index where this placeholder is on grid */
        private int row = -1;
        /* column index where this placeholder should be on grid */
        private int column = -1;
        /* node's value per se */
        private char letter = '-';

        /*
         * denotes whether intersecting letter or cell that shared by multiple
         * words
         */
        private boolean isCrossLetter;
        /* link to next cell in this sequence */
        private CellNode link = null;

        public CellNode(final int row, final int column, final CellNode link) {
            this.row = row;
            this.column = column;
            this.link = link;
        }


        //Check first element and check if it is crossletter and recursively send substring.
        public boolean accept(final String w, final Map<CellNode, Character> crossLetterCheck) {

            if (w.length() > 0) {
                letter = w.charAt(0);

                if (isCrossLetter) {
                    crossLetterCheck.putIfAbsent(this, letter);
                    if (crossLetterCheck.get(this).charValue() != letter) {
                        return false;
                    }
                }

                // if not return false
                if (w.length() == 1) {
                    return !hasNextLink();
                }
                return hasNextLink() && link.accept(w.substring(1), crossLetterCheck);
            }

            return false;
        }

        public boolean hasNextLink() {
            return link != null;
        }

        public void visit(Consumer<CellNode> consumer) {
            consumer.accept(this);
            if (hasNextLink()) {
                consumer.accept(link);
                link.visit(consumer);
            }
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + column;
            result = prime * result + row;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            CellNode other = (CellNode) obj;

            if (column != other.column)
                return false;
            if (row != other.row)
                return false;
            return true;
        }

        @Override
        public String toString() {
            String out =  "CellNode{" +
                    "row=" + row +
                    ", column=" + column +
                    ", letter=" + letter +
                    ", isCrossLetter=" + isCrossLetter +
                    "\n\t, link=" + link +
                    ')';

            if(link == null) {
                out += "\n\n";
            }
            return out;

        }
    }

}
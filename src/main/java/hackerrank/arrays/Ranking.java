package hackerrank.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Ranking {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str=null;

        str = br.readLine();
        String[] prizeRankwise = str.split("\\s+");

        Long[] prizeRankwiseLong = Arrays.stream(prizeRankwise)
                .map(Long::valueOf)
                .toArray(Long[]::new);

        //str = br.readLine();
        long totalPrizeMoney = Arrays.stream(prizeRankwiseLong).reduce((a,b) -> a+b).get();
        System.out.println("totalPrizeMoney="+totalPrizeMoney);

        str = br.readLine();
        long participants = Long.parseLong(str);

        str = br.readLine();
        String[] pointsStr = str.split("\\s+");

        str = br.readLine();
        String[] partIdStr = str.split("\\s+");

        Long[] points = Arrays.stream(pointsStr)
                .map(Long::valueOf)
                .toArray(Long[]::new);

        int i=0;
        PointUser[] pointUsers = new PointUser[points.length];
        for (Long point:points) {
            pointUsers[i]=new PointUser(point, partIdStr[i]);
            i++;
        }

        Comparator<PointUser> comparator = Comparator.comparing(PointUser::getPoints).reversed();
        Arrays.sort(pointUsers, comparator);

        Arrays.stream(pointUsers).forEach(System.out::println);


        Long[] ranks = new Long[pointUsers.length];

        Long rank = 1l;
        long tracePoints = pointUsers[0].getPoints();
        long sum = prizeRankwiseLong[0];
        int j=0;
        int p=0;
        int t=0;
        for (PointUser pointUser:pointUsers) {
            System.out.println("j==" + j);
            if(pointUser.getPoints() == tracePoints) {
                pointUser.setRank(rank);

                if(j == 0) {
                    sum = prizeRankwiseLong[0];
                } else {
                    sum = sum + prizeRankwiseLong[j];
                    t=j;
                }
                j++;
            }
            else {
                setPrizeMoney(pointUsers, sum, p, t);
                t = j;
                p = j;
                sum = prizeRankwiseLong[j];

                tracePoints = pointUser.getPoints();
                pointUser.setRank(++rank);
                j++;
            }

            if(j==pointUsers.length-1) {
                sum = sum + prizeRankwiseLong[j];
                t=j;
                setPrizeMoney(pointUsers, sum, p, t);
            }
        }

        Arrays.stream(pointUsers).forEach(System.out::println);
    }

    private static void setPrizeMoney(PointUser[] pointUsers, long sum, int p, int t) {
        if(p == t) {
            pointUsers[p].setPrizeMoney(sum);
        } else {
            double avg = (double)sum/(t-p+1);
            for (int i=p; i<=t; i++) {
                pointUsers[i].setPrizeMoney(avg);
            }
        }
    }

    static class PointUser {
        Long points;
        String userId;
        Long rank = 0l;
        double prizeMoney = 0l;

        public double getPrizeMoney() {
            return prizeMoney;
        }

        public void setPrizeMoney(double prizeMoney) {
            this.prizeMoney = prizeMoney;
        }

        public PointUser(Long points, String userId) {
            this.points = points;
            this.userId = userId;
        }

        public Long getPoints() {
            return points;
        }

        public void setPoints(Long points) {
            this.points = points;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public Long getRank() {
            return rank;
        }

        public void setRank(Long rank) {
            this.rank = rank;
        }

        @Override
        public String toString() {
            return "PointUser{" +
                    "points=" + points +
                    ", userId='" + userId + '\'' +
                    ", rank=" + rank +
                    ", prizeMoney=" + prizeMoney +
                    '}';
        }
    }
}

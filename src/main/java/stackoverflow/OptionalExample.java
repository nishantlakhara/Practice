package stackoverflow;

import java.io.FileFilter;
import java.util.Optional;
import java.util.function.BiConsumer;

public class OptionalExample {

    public static void main(String[] args) {
        new OptionalExample().processEvent(new Event());
    }

//    processEvent(Event event) {
//        if ( isEventOfSpecificType(event) ){ .............................................. 1
//
//            Result result = findSomeData(event.someProperty()) ............................. 2
//            if(result.someStatus == somevalue) { ........................................... 3
//
//                saveEvent(event, result) // save to DB with properties from both objects ... 4
//                String referenceID = createSomeRecord(event, result) // Will do API call ... 5
//                writeToLogFile(event, result, referenceID) // write to a logfile ........... 6
//            }
//        }
//    }

    public void processEvent(final Event event) {
        Optional.of(event)
                .filter(this::isEventOfSpecificType)
                .map(e -> findSomeData(e.someProperty()))
                .ifPresent(r -> resultBiConsumer.accept(r, event));
    }

    private BiConsumer<Optional<Result>, Event> resultBiConsumer = (result, event) ->  {
            if(result.isPresent()) {
                Result r = result.get();
                if(r.getStatus() == 0) {
                    saveEvent(event, r);
                    String referenceID = createSomeRecord(event, r);
                    writeToLogFile(event, r, referenceID);
                }
            }
        };


//    private BiConsumer<Result, Event> processData() {
//        return (result, event) ->  {
//            saveEvent(event, result);
//            String referenceID = createSomeRecord(event, result);
//            writeToLogFile(event, result, referenceID);
//        };
//    }

    private void writeToLogFile(Event event, Result result, String referenceID) {
        System.out.println("writeToLogFile");
    }

    private String createSomeRecord(Event event, Result result) {
        System.out.println("createSomeRecord");
        return "somestring";
    }

    private void saveEvent(Event event, Result result) {
        System.out.println("Event saved");
    }

    private Optional<Result> findSomeData(Integer someProperty) {
        return Optional.of(new Result(someProperty));
    }

    private boolean isEventOfSpecificType(Event event) {
        return true;
    }

}

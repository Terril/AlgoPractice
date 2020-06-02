public class SnapchatTimeTable {

    public static void main(String args[]) {
        ClassTimeTable timeTable = new ClassTimeTable(30, 75);
        ClassTimeTable timeTabl1 = new ClassTimeTable(0, 50);
        ClassTimeTable timeTable2 = new ClassTimeTable(60, 150);
        ClassTimeTable timeTable3 = new ClassTimeTable(0, 500);
        ClassTimeTable timeTable4 = new ClassTimeTable(40, 70);
        ClassTimeTable[] timeTables = new ClassTimeTable[]{timeTable, timeTabl1, timeTable2,
                timeTable3, timeTable4};

        int rooms = findNumberofRoomsNeeded(timeTables);
        System.out.println(rooms);
    }

    private static int findNumberofRoomsNeeded(ClassTimeTable[] timeTables) {
        int max_rooms = 0;

        for (int v = 0; v < timeTables.length; v++) {
            int rooms = 1;
            for (int u = 0; u < timeTables.length; u++) {
                if (timeTables[u].startTime > timeTables[v].startTime && timeTables[u].startTime < timeTables[v].endTime)
                    rooms += 1;
            }

            if (rooms > max_rooms) {
                max_rooms = rooms;
            }
        }

        return max_rooms;
    }

    static class ClassTimeTable {
        int startTime;
        int endTime;

        ClassTimeTable(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

    }
}

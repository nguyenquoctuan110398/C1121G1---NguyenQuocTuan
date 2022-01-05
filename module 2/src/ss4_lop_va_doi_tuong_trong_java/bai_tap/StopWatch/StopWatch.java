package ss4_lop_va_doi_tuong_trong_java.bai_tap.StopWatch;

public class StopWatch {
    long startTime;
    long endTime;

    public StopWatch() {
        this.startTime = System.currentTimeMillis();
    }

    private long getStartTime() {
        return this.startTime;
    }

    private long getEndTime() {
        return this.endTime;
    }

    public void start() {
        this.startTime=System.currentTimeMillis();
    }

    public void stop() {
        this.endTime=System.currentTimeMillis();
    }

    public long getElapsedTime() {
        return this.getEndTime()-this.getStartTime();
    }
}

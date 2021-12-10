package ss4_lop_va_doi_tuong_trong_java.bai_tap.xay_dung_lop_stopwatch;

public class StopWatch {
    private long startTime;
    private long endTime;

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }
    public StopWatch(){
        this.startTime=System.currentTimeMillis();
        //trả về một số nguyên tính từ năm 1970 đến thời điểm hiện tại
    }
    public StopWatch(long startTime, long endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public void start(){
        this.startTime = System.currentTimeMillis();
    }
    public void stop(){
        this.endTime = System.currentTimeMillis();
    }
    public long getElapsedTime(){
        return getEndTime()-getStartTime();
    }
}

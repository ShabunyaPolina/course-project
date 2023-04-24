package by.bsu.courseproject.model;

public enum RefreshmentStage {

    FIRST(1),
    SECOND(3),
    THIRD(5);

    public final Integer interval;
    public static final RefreshmentStage[] values = values();

    private RefreshmentStage(Integer interval) {
        this.interval = interval;
    }

    public RefreshmentStage prev() {
        return values[(ordinal() - 1  + values.length) % values.length];
    }

    public RefreshmentStage next() {
        return values[(ordinal() + 1) % values.length];
    }

}

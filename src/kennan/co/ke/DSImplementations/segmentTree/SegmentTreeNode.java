package kennan.co.ke.DSImplementations.segmentTree;

public class SegmentTreeNode<T> {

    private Integer sum;
    private Integer minimum;
    private Integer maximum;

    public SegmentTreeNode() {
    }


    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public Integer getMinimum() {
        return minimum;
    }

    public void setMinimum(Integer minimum) {
        this.minimum = minimum;
    }

    public Integer getMaximum() {
        return maximum;
    }

    public void setMaximum(Integer maximum) {
        this.maximum = maximum;
    }

    @Override
    public String toString() {
        return "SegmentTreeNode{" +
                "sum=" + sum +
                ", minimum=" + minimum +
                ", maximum=" + maximum +
                '}';
    }
}


public class Song{
    private String name;
    private int length;
    private boolean finale;
    private boolean selected;

    public Song(String name, int length, boolean finale) {
        this.name = name;
        this.length = length;
        this.finale = finale;
        this.selected = false;
    }

    public String getName() {return name;}
    public int getLength() {return length;}
    public boolean isFinale() {return finale;}
    public boolean isSelected() {return selected;}

    public void setName(String name) {this.name = name;}
    public void setLength(int length) {this.length = length;}
    public void setFinale(boolean finale) {this.finale = finale;}
    public void setSelected(boolean selected) {this.selected = selected;}

    @Override
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                ", length=" + length +
                ", finale=" + finale +
                ", selected=" + selected +
                '}';
    }
}
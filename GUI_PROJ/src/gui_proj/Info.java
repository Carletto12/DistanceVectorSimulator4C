package gui_proj;

class Info {
    int archCost, from;
    
    Info(int c, int f) {
        archCost = c;
        from = f;
    }
    @Override
    public String toString() {
        return archCost +"";
    }
}
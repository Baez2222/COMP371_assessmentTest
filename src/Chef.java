public class Chef {
    private boolean cooking;

    public Chef(boolean cooking){
        this.cooking = cooking;
    }

    public void setChefStatus(boolean cooking){ this.cooking = cooking; }

    public boolean getChefStatus(){ return this.cooking; }
}

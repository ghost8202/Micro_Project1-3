package Micro_Project1_3;

interface Callback {
    void callback(); 
}

class runMusic implements Runnable{
	

    Callback c; 

    public runMusic(Callback c) {
        this.c = c;
    }

    public void run() {
    	PlayMusicProgressBar pm=new PlayMusicProgressBar();
		pm.playMusicProgressBar();
		pm.pack();
		pm.setVisible(true);
		pm.iterate();
        this.c.callback();
    }

}

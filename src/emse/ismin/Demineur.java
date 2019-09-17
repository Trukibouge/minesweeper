package emse.ismin;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Truki
 * @version 0.1, 2019/9/3
 */
public class Demineur extends JFrame {
	
	private Level defaultLevel = Level.MEDIUM;
	private int score = 0;
	private Champ champ = new Champ(defaultLevel);
    private DemineurGUI appGui;
    
    private boolean started = false;

    public void setStarted (boolean started){
        this.started = started;
    }

    public boolean isStarted(){
        return started;
    }
	
	public DemineurGUI getAppGui() {
		return appGui;
	}

	/**
	 * Create mine field
	 */
	public Demineur() {
		super("Demineur");
		champ.newGame();
		appGui = new DemineurGUI(this);
		setContentPane(appGui);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new Demineur();
	}
	
	public void quit() {
		System.out.println("Exiting app...");
		System.exit(0);
	}
	
	public Champ getChamp() {
		return (champ);
	}
	
	public Level getLevel() {
		return(defaultLevel);
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void reset() {
        champ.newGame();
        started = false;
		score = 0;
	}
	
	public void newDifficulty(Level difficulty) {
        this.champ = new Champ(difficulty);
		reset();
	}

}
class StableMatching{
	private int N,engagedCount;
	private String [] men;
	private String [] women;
	private String [][] mpref;
	private String [][] wpref;
	private String [] womenPartner;
	private boolean [] menengaged;


	public StableMatching(String []m,String []w,String [][] mp, String[][] wp){
		N = mp.length;
		engagedCount = 0;
		men = m;
		women = w;
		mpref = mp;
		wpref = wp;
		womenPartner = new String[N];
		menengaged = new boolean[N];
		calcMatch();
	}


	private void calcMatch(){

		while(engagedCount < N){
			int free;
			for(free = 0;free<N;free++)
				if(!menengaged[free])
					break;
			for(int i=0;i<N && !menengaged[free];i++){
				int index = womenIndexof(mpref[free][i]);
				if(womenPartner[index] == null){
					womenPartner[index] = men[free];
					menengaged[free] = true;
					engagedCount++;
				}
				else{
					String currentPartner = womenPartner[index];
					if(morePreference(currentPartner,men[free],index)){
						womenPartner[index] = men[free];
						menengaged[free] = true;
						menengaged[menIndexof(currentPartner)] = false;
					}
				}
			}
		}
		printMatching();
	}

	private boolean morePreference(String currentPartner,String newPartner,int index){
		for(int i=0;i<N;i++){
			if(wpref[index][i].equals(newPartner))
				return true;
			if(wpref[index][i].equals(currentPartner))
				return false;
		}
		return false;
	}

	private int womenIndexof(String str){
		for(int i=0;i<N;i++){
			if(women[i].equals(str))
				return i;
		}
		return -1;
	}

	private int menIndexof(String str){
		for(int i=0;i<N;i++){
			if(men[i].equals(str))
				return i;
		}
		return -1;
	}

	private void printMatching(){
		for(int i=0;i<N;i++)
			System.out.println(womenPartner[i]+" "+women[i]);
	}

	public static void main(String args[]){
		
		String []m = {"A","B","C","D"};
		String []w = {"W","X","Y","Z"};

		String [][] mp = {{"W","X","Y","Z"}, 
                         {"X","W","Y","Z"}, 
                         {"Z","W","Y","X"}, 
                         {"Z","Y","X","W"}};
		
		String [][] wp = {{"A","B","D","C"}, 
                         {"B","C","A","D"}, 
                         {"C","D","A","B"},
                         {"C","D","A","B"}};

        StableMatching sm = new StableMatching(m,w,mp,wp);
	}
}
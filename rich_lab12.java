//import example4.ButtonActionListener;

import java.io.FileNotFoundException;
import java.io.IOException;

public class rich_lab12 {
    
    //sets width and hight for pref and min size
    private static int width = 700;
	private static int height = 350;

    //hosts file sizes before we call the actual one
    //private static java.util.ArrayList<Integer> tempesortnight = new java.util.ArrayList<>();
    //private static java.util.ArrayList<Integer> tempesearchnight = new java.util.ArrayList<>(); 

    private static boolean searched = false;
    private static boolean sortintbo = false;
    private static boolean bstbool = false;
    private static boolean treebool = false;
    private static boolean priqbool = false;
    private static boolean hashbool = false;
    private static boolean arrlisbool = false;
    private static boolean sortedarrlisbool = false;
    private static boolean arrbool = false;

    private static boolean countbool = false;

    private static String sortfilename;
    private static String searchfilename;

    

    //main holder of file vals
    private static int[] sortVals;
    private static int[] searchVals;

    //used in methodoldical (left)
    //private static int[] sortedVals;
    private static java.util.TreeSet<Integer> treesetvals = new java.util.TreeSet<>();
    private static java.util.HashSet<Integer> hashsetvals = new java.util.HashSet<>();
    private static java.util.PriorityQueue<Integer> priQvals = new java.util.PriorityQueue<>();
    private static java.util.ArrayList<Integer> arraylistvals = new java.util.ArrayList<>();
    private static java.util.ArrayList<Integer> sortedarrlisvals = new java.util.ArrayList<>();
    //private static rich_BinarySearchTree binsearchtree = new rich_BinarySearchTree();
    private static java.util.TreeSet<Integer> bintreeset = new java.util.TreeSet<>();
    private static int[] unsortedvals;

    //used in methoddoldical (rihgt)
    
//creating buttons

    //left button panel
    private static javax.swing.JButton sortintsB = new javax.swing.JButton("sort ints");
    private static javax.swing.JButton addbst = new javax.swing.JButton("add to bst");
    private static javax.swing.JButton addtree = new javax.swing.JButton("add to treeset");
    private static javax.swing.JButton addpriq = new javax.swing.JButton("add to priority queue");
    private static javax.swing.JButton addhash = new javax.swing.JButton("add to hashset");
    private static javax.swing.JButton addarrlis = new javax.swing.JButton("add to arraylist");
    private static javax.swing.JButton addsortarrlis = new javax.swing.JButton("add to sorted array list");
    private static javax.swing.JButton addarr = new javax.swing.JButton("add to array");

    //right button panel
    private static javax.swing.JButton searchsortints = new javax.swing.JButton("search sorted ints");
    private static javax.swing.JButton searchbst = new javax.swing.JButton("search bst");
    private static javax.swing.JButton searchtree = new javax.swing.JButton("search treeset");
    private static javax.swing.JButton searchpriq = new javax.swing.JButton("search priority queue");
    private static javax.swing.JButton searchhash = new javax.swing.JButton("search hashset");
    private static javax.swing.JButton searcharrlis = new javax.swing.JButton("search arraylist");
    private static javax.swing.JButton searchsortarrlis = new javax.swing.JButton("search sorted arraylist");
    private static javax.swing.JButton searcharr = new javax.swing.JButton("search array");


    //creating labels
    private static javax.swing.JLabel sortintsBtime = new javax.swing.JLabel("no result");
    private static javax.swing.JLabel addbsttime = new javax.swing.JLabel("no result");
    private static javax.swing.JLabel addtreetime = new javax.swing.JLabel("no result");
    private static javax.swing.JLabel addpriqtime = new javax.swing.JLabel("no result");
    private static javax.swing.JLabel addhashtime = new javax.swing.JLabel("no result");
    private static javax.swing.JLabel addarrlistime = new javax.swing.JLabel("no result");
    private static javax.swing.JLabel addsortarrlistime = new javax.swing.JLabel("no result");
    private static javax.swing.JLabel addarrtime = new javax.swing.JLabel("no result");

    private static javax.swing.JLabel searchsortintstime = new javax.swing.JLabel("no result");
    private static javax.swing.JLabel searchbsttime = new javax.swing.JLabel("no result");
    private static javax.swing.JLabel searchtreetime = new javax.swing.JLabel("no result");
    private static javax.swing.JLabel searchpriqtime = new javax.swing.JLabel("no result");
    private static javax.swing.JLabel searchhashtime = new javax.swing.JLabel("no result");
    private static javax.swing.JLabel searcharrlistime = new javax.swing.JLabel("no result");
    private static javax.swing.JLabel searchsortarrlistime = new javax.swing.JLabel("no result");
    private static javax.swing.JLabel searcharrtime = new javax.swing.JLabel("no result");


    public static void main(String[] args) {

        sortfilename = args[0];
        searchfilename = args[1];

        if( args.length != 2 )
		{
			System.out.println("Inavlit ammount of arguments");
			System.exit(0);

            //String huppa = args[0];
            //String hoppa = args[1];
		}
        
        
        
        



        
        javax.swing.JFrame f = new javax.swing.JFrame(); // creates jframe
		f.setPreferredSize(new java.awt.Dimension(width, height));
		f.setMinimumSize(new java.awt.Dimension(width, height));
		f.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);

        //creating menu bar
        javax.swing.JMenuBar menuBar = new javax.swing.JMenuBar();

        // createing the file jmenu
		javax.swing.JMenu fileMenu = new javax.swing.JMenu("File");

        //adding filemenu to bar
        menuBar.add(fileMenu);

        //creating the 3 jmenu items
        javax.swing.JMenuItem readsortfile = new javax.swing.JMenuItem("Read Sort File");
        javax.swing.JMenuItem readsearchfile = new javax.swing.JMenuItem("Read Search File");
        javax.swing.JMenuItem exitMenu = new javax.swing.JMenuItem("Exit");

        //adding items to fileMenu
        fileMenu.add(readsortfile);
        fileMenu.add(readsearchfile);
		fileMenu.add(exitMenu);
 

        MenuItemActionListener fileExitMenuItemActionListener = new MenuItemActionListener(exitMenu);
        MenuItemActionListener readsortfileItemActionListener = new MenuItemActionListener(readsortfile);
        MenuItemActionListener readsearchfileItemActionListener = new MenuItemActionListener(readsearchfile);
        

        // add the action listeners to the menu items
		exitMenu.addActionListener(fileExitMenuItemActionListener);
        readsortfile.addActionListener(readsortfileItemActionListener);
        readsearchfile.addActionListener(readsearchfileItemActionListener);

        
        java.awt.GridBagLayout gridBagLayout = new java.awt.GridBagLayout();

        // create the Leftbuttonpanel to hold the buttons
		javax.swing.JPanel LeftbuttonPanel = new javax.swing.JPanel();
		LeftbuttonPanel.setLayout(gridBagLayout);
        LeftbuttonPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0, 255), 2));
        //set sizes
        LeftbuttonPanel.setPreferredSize(new java.awt.Dimension(330, 350));
		LeftbuttonPanel.setMinimumSize(new java.awt.Dimension(330, 350));
		
        //creating rightbuttonpanel
        javax.swing.JPanel RightbuttonPanel = new javax.swing.JPanel();
		RightbuttonPanel.setLayout(gridBagLayout);
        RightbuttonPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0, 255), 2));
        java.awt.GridBagConstraints buttonPanelConstraints = new java.awt.GridBagConstraints();
        //set sizes
        RightbuttonPanel.setPreferredSize(new java.awt.Dimension(330, 350));
		RightbuttonPanel.setMinimumSize(new java.awt.Dimension(330, 350));

        //creating mainbuttonpanel
        // create the panel to hold the Two buttons
		javax.swing.JPanel buttonPanel = new javax.swing.JPanel();
		javax.swing.BoxLayout boxLayout = new javax.swing.BoxLayout(buttonPanel, javax.swing.BoxLayout.X_AXIS);
		buttonPanel.setLayout(boxLayout);
		
        //adding left and right to main
        buttonPanel.add(LeftbuttonPanel);
        buttonPanel.add(RightbuttonPanel);

        //creating main panel
        javax.swing.JPanel mainPanel = new javax.swing.JPanel();
		mainPanel.setLayout(new java.awt.BorderLayout());
        mainPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0, 255), 2));
		mainPanel.add(menuBar, java.awt.BorderLayout.NORTH);
		mainPanel.add(buttonPanel, java.awt.BorderLayout.CENTER);

        //button contraints
        // make the weights non zero so that the components spread out 
		buttonPanelConstraints.weightx = 1;
		buttonPanelConstraints.weighty = 1;


        buttonPanelConstraints.weightx = 1;
        buttonPanelConstraints.weighty = 1;
        buttonPanelConstraints.fill = java.awt.GridBagConstraints.NONE;
        buttonPanelConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
		
//left pannel

        buttonPanelConstraints.gridx = 0;
        buttonPanelConstraints.gridy = 0;
		buttonPanelConstraints.gridwidth = 1;
        gridBagLayout.setConstraints(sortintsB, buttonPanelConstraints);

        //
        buttonPanelConstraints.gridx = 2;
		buttonPanelConstraints.gridy = 0;
		buttonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagLayout.setConstraints(sortintsBtime, buttonPanelConstraints);

        buttonPanelConstraints.gridx = 0;
        buttonPanelConstraints.gridy = 1;
		buttonPanelConstraints.gridwidth = 1;
        gridBagLayout.setConstraints(addbst, buttonPanelConstraints);

        //
        buttonPanelConstraints.gridx = 2;
		buttonPanelConstraints.gridy = 1;
		buttonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagLayout.setConstraints(addbsttime, buttonPanelConstraints);

        buttonPanelConstraints.gridx = 0;
        buttonPanelConstraints.gridy = 2;
		buttonPanelConstraints.gridwidth = 1;
        gridBagLayout.setConstraints(addtree, buttonPanelConstraints);

        //
        buttonPanelConstraints.gridx = 2;
		buttonPanelConstraints.gridy = 2;
		buttonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagLayout.setConstraints(addtreetime, buttonPanelConstraints);

        buttonPanelConstraints.gridx = 0;
        buttonPanelConstraints.gridy = 3;
		buttonPanelConstraints.gridwidth = 1;
        gridBagLayout.setConstraints(addpriq, buttonPanelConstraints);

        //
        buttonPanelConstraints.gridx = 2;
		buttonPanelConstraints.gridy = 3;
		buttonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagLayout.setConstraints(addpriqtime, buttonPanelConstraints);

        buttonPanelConstraints.gridx = 0;
        buttonPanelConstraints.gridy = 4;
		buttonPanelConstraints.gridwidth = 1;
        gridBagLayout.setConstraints(addhash, buttonPanelConstraints);

        //
        buttonPanelConstraints.gridx = 2;
		buttonPanelConstraints.gridy = 4;
		buttonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagLayout.setConstraints(addhashtime, buttonPanelConstraints);
        
        buttonPanelConstraints.gridx = 0;
        buttonPanelConstraints.gridy = 5;
		buttonPanelConstraints.gridwidth = 1;
        gridBagLayout.setConstraints(addarrlis, buttonPanelConstraints);

        //
        buttonPanelConstraints.gridx = 2;
		buttonPanelConstraints.gridy = 5;
		buttonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagLayout.setConstraints(addarrlistime, buttonPanelConstraints);

        buttonPanelConstraints.gridx = 0;
        buttonPanelConstraints.gridy = 6;
		buttonPanelConstraints.gridwidth = 1;
        gridBagLayout.setConstraints(addsortarrlis, buttonPanelConstraints);

        //
        buttonPanelConstraints.gridx = 2;
		buttonPanelConstraints.gridy = 6;
		buttonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagLayout.setConstraints(addsortarrlistime, buttonPanelConstraints);

        buttonPanelConstraints.gridx = 0;
        buttonPanelConstraints.gridy = 7;
		buttonPanelConstraints.gridwidth = 1;
        gridBagLayout.setConstraints(addarr, buttonPanelConstraints);

        //
        buttonPanelConstraints.gridx = 2;
		buttonPanelConstraints.gridy = 7;
		buttonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagLayout.setConstraints(addarrtime, buttonPanelConstraints);



        //right pannel connstraints

        buttonPanelConstraints.gridx = 0;
        buttonPanelConstraints.gridy = 0;
		buttonPanelConstraints.gridwidth = 1;
        gridBagLayout.setConstraints(searchsortints, buttonPanelConstraints);

        //
        buttonPanelConstraints.gridx = 2;
		buttonPanelConstraints.gridy = 0;
		buttonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagLayout.setConstraints(searchsortintstime, buttonPanelConstraints);

        buttonPanelConstraints.gridx = 0;
        buttonPanelConstraints.gridy = 1;
		buttonPanelConstraints.gridwidth = 1;
        gridBagLayout.setConstraints(searchbst, buttonPanelConstraints);

        //
        buttonPanelConstraints.gridx = 2;
		buttonPanelConstraints.gridy = 1;
		buttonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagLayout.setConstraints(searchbsttime, buttonPanelConstraints);

        buttonPanelConstraints.gridx = 0;
        buttonPanelConstraints.gridy = 2;
		buttonPanelConstraints.gridwidth = 1;
        gridBagLayout.setConstraints(searchtree, buttonPanelConstraints);

        //
        buttonPanelConstraints.gridx = 2;
		buttonPanelConstraints.gridy = 2;
		buttonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagLayout.setConstraints(searchtreetime, buttonPanelConstraints);

        buttonPanelConstraints.gridx = 0;
        buttonPanelConstraints.gridy = 3;
		buttonPanelConstraints.gridwidth = 1;
        gridBagLayout.setConstraints(searchpriq, buttonPanelConstraints);

        //
        buttonPanelConstraints.gridx = 2;
		buttonPanelConstraints.gridy = 3;
		buttonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagLayout.setConstraints(searchpriqtime, buttonPanelConstraints);

        buttonPanelConstraints.gridx = 0;
        buttonPanelConstraints.gridy = 4;
		buttonPanelConstraints.gridwidth = 1;
        gridBagLayout.setConstraints(searchhash, buttonPanelConstraints);

        //
        buttonPanelConstraints.gridx = 2;
		buttonPanelConstraints.gridy = 4;
		buttonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagLayout.setConstraints(searchhashtime, buttonPanelConstraints);

        buttonPanelConstraints.gridx = 0;
        buttonPanelConstraints.gridy = 5;
		buttonPanelConstraints.gridwidth = 1;
        gridBagLayout.setConstraints(searcharrlis, buttonPanelConstraints);

        //
        buttonPanelConstraints.gridx = 2;
		buttonPanelConstraints.gridy = 5;
		buttonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagLayout.setConstraints(searcharrlistime, buttonPanelConstraints);

        buttonPanelConstraints.gridx = 0;
        buttonPanelConstraints.gridy = 6;
		buttonPanelConstraints.gridwidth = 1;
        gridBagLayout.setConstraints(searchsortarrlis, buttonPanelConstraints);

        //
        buttonPanelConstraints.gridx = 2;
		buttonPanelConstraints.gridy = 6;
		buttonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagLayout.setConstraints(searchsortarrlistime, buttonPanelConstraints);

        buttonPanelConstraints.gridx = 0;
        buttonPanelConstraints.gridy = 7;
		buttonPanelConstraints.gridwidth = 1;
        gridBagLayout.setConstraints(searcharr, buttonPanelConstraints);

        //
        buttonPanelConstraints.gridx = 2;
		buttonPanelConstraints.gridy = 7;
		buttonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagLayout.setConstraints(searcharrtime, buttonPanelConstraints);




        //adding to left button panel
        LeftbuttonPanel.add(sortintsB);
        LeftbuttonPanel.add(addbst);
        LeftbuttonPanel.add(addtree);
        LeftbuttonPanel.add(addpriq);
        LeftbuttonPanel.add(addhash);
        LeftbuttonPanel.add(addarrlis);
        LeftbuttonPanel.add(addsortarrlis);
        LeftbuttonPanel.add(addarr);

        //adding labels
        LeftbuttonPanel.add(sortintsBtime);
        LeftbuttonPanel.add(addbsttime);
        LeftbuttonPanel.add(addtreetime);
        LeftbuttonPanel.add(addpriqtime);
        LeftbuttonPanel.add(addhashtime);
        LeftbuttonPanel.add(addarrlistime);
        LeftbuttonPanel.add(addsortarrlistime);
        LeftbuttonPanel.add(addarrtime);

        //adding to right button panel
        RightbuttonPanel.add(searchsortints);
        RightbuttonPanel.add(searchbst);
        RightbuttonPanel.add(searchtree);
        RightbuttonPanel.add(searchpriq);
        RightbuttonPanel.add(searchhash);
        RightbuttonPanel.add(searcharrlis);
        RightbuttonPanel.add(searchsortarrlis);
        RightbuttonPanel.add(searcharr);

        //labels adding
        RightbuttonPanel.add(searchsortintstime);
        RightbuttonPanel.add(searchbsttime);
        RightbuttonPanel.add(searchtreetime);
        RightbuttonPanel.add(searchpriqtime);
        RightbuttonPanel.add(searchhashtime);
        RightbuttonPanel.add(searcharrlistime);
        RightbuttonPanel.add(searchsortarrlistime);
        RightbuttonPanel.add(searcharrtime);

    //creating action listeners fo rbuttons
    //lef
    ButtonActionListener sortintsAL = new ButtonActionListener(sortintsB);
    ButtonActionListener addbstAL = new ButtonActionListener(addbst);
    ButtonActionListener addtreeAL = new ButtonActionListener(addtree);
    ButtonActionListener addpriqAL = new ButtonActionListener(addpriq);
    ButtonActionListener addhashAL = new ButtonActionListener(addhash);
    ButtonActionListener addarrlisAL = new ButtonActionListener(addarrlis);
    ButtonActionListener addsortarrlisAL = new ButtonActionListener(addsortarrlis);
    ButtonActionListener addarrAL = new ButtonActionListener(addarr);

    //rihg
    ButtonActionListener searchsortintsAL = new ButtonActionListener(searchsortints);
    ButtonActionListener searchbstAL = new ButtonActionListener(searchbst);
    ButtonActionListener searchtreeAL = new ButtonActionListener(searchtree);
    ButtonActionListener searchpriqAL = new ButtonActionListener(searchpriq);
    ButtonActionListener searchhashAL = new ButtonActionListener(searchhash);
    ButtonActionListener searcharrlisAL = new ButtonActionListener(searcharrlis);
    ButtonActionListener searchsortarrlisAL = new ButtonActionListener(searchsortarrlis);
    ButtonActionListener searcharrAL = new ButtonActionListener(searcharr);

    //adding to button lmao
    //telf
    sortintsB.addActionListener(sortintsAL);
    addbst.addActionListener(addbstAL);
    addtree.addActionListener(addtreeAL);
    addpriq.addActionListener(addpriqAL);
    addhash.addActionListener(addhashAL);
    addarrlis.addActionListener(addarrlisAL);
    addsortarrlis.addActionListener(addsortarrlisAL);
    addarr.addActionListener(addarrAL);

    //tghkr
    searchsortints.addActionListener(searchsortintsAL);
    searchbst.addActionListener(searchbstAL);
    searchtree.addActionListener(searchtreeAL);
    searchpriq.addActionListener(searchpriqAL);
    searchhash.addActionListener(searchhashAL);
    searcharrlis.addActionListener(searcharrlisAL);
    searchsortarrlis.addActionListener(searchsortarrlisAL);
    searcharr.addActionListener(searcharrAL);


    sortintsB.setEnabled(false);
    addbst.setEnabled(false);
    addtree.setEnabled(false);
    addpriq.setEnabled(false);
    addhash.setEnabled(false);
    addarrlis.setEnabled(false);
    addsortarrlis.setEnabled(false);
    addarr.setEnabled(false);

    searchsortints.setEnabled(false);
    searchbst.setEnabled(false);
    searchtree.setEnabled(false);
    searchpriq.setEnabled(false);
    searchhash.setEnabled(false);
    searcharrlis.setEnabled(false);
    searchsortarrlis.setEnabled(false);
    searcharr.setEnabled(false);




//end of sequence validation
        f.setContentPane(mainPanel);

        f.validate();
		f.setVisible(true);
    }

    static class ButtonActionListener implements java.awt.event.ActionListener
	{
		// the button associated with the action listener, so that we can
		// share this one class with multiple buttons
		private javax.swing.JButton b;
		
		ButtonActionListener(javax.swing.JButton b)
		{
            
			this.b = b;
		}
		
		public void actionPerformed(java.awt.event.ActionEvent e)
		{
            long t0 = System.currentTimeMillis();
            javax.swing.JLabel l = sortintsBtime;
            //switch case statement?
            if (b.getText() == "sort ints") {
                selectionsort();
                l = sortintsBtime;
                if(searched) {
                    searchsortints.setEnabled(true);
                }
                else {
                    sortintbo = true;
                }
            }

            if (b.getText() == "add to bst") {
                AddBinSearchTree();
                l = addbsttime;
                if(searched) {
                    searchbst.setEnabled(true);
                }
                else {
                    bstbool = true;
                }
                
            }

            if (b.getText() == "add to treeset") {
                AddTreeSet();
                l = addtreetime;
                if(searched) {
                    searchtree.setEnabled(true);
                }
                else {
                    treebool = true;
                }
            }

            if (b.getText() == "add to priority queue") {
                AddPriQ();
                l = addpriqtime;
                if(searched) {
                    searchpriq.setEnabled(true);
                }
                else {
                    priqbool = true;
                }
            }

            if (b.getText() == "add to hashset") {
                AddHashSet();
                l = addhashtime;
                if(searched) {
                    searchhash.setEnabled(true);
                }
                else {
                    hashbool = true;
                }

            }

            if (b.getText() == "add to arraylist") {
                AddArrayList();
                l = addarrlistime;
                if(searched) {
                    searcharrlis.setEnabled(true);
                }
                else {
                    arrlisbool = true;
                }
            }

            if (b.getText() == "add to sorted array list") {
                AddSortedArrLis();
                l = addsortarrlistime;
                if(searched) {
                    searchsortarrlis.setEnabled(true);
                }
                else {
                    sortedarrlisbool = true;
                }
            }

            if (b.getText() == "add to array") {
                AddArray();
                l = addarrtime;
                if(searched) {
                    searcharr.setEnabled(true);
                }
                else {
                    sortintbo = true;
                }
            }


            //right
            int count = 0;
            if (b.getText() == "search sorted ints") {
                count = SearchInts();
                l = searchsortintstime;
                countbool = true;
            }

            if (b.getText() == "search bst") {
                count = SearchBinSearchTree();
                l = searchbsttime;
                countbool = true;
            }

            if (b.getText() == "search treeset") {
                count = SearchTreeSet();
                l = searchtreetime;
                countbool = true;
            }

            if (b.getText() == "search priority queue") {
                count = SearchPriQ();
                l = searchpriqtime;
                countbool = true;
            }
            
            if (b.getText() == "search hashset") {
                count = SearchHashSet();
                l = searchhashtime;
                countbool = true;
            }

            if (b.getText() == "search arraylist") {
                count = SearchArrLis();
                l = searcharrlistime;
                countbool = true;
            }

            if (b.getText() == "search sorted arraylist") {
                count = SearchSortedArrLis();
                l = searchsortarrlistime;
                countbool = true;
            }

            if (b.getText() == "search array") {
                count = SearchArr();
                l = searcharrtime;
                countbool = true;
            }


            long t1 = System.currentTimeMillis();
            if(countbool) {
                l.setText(count + " / " + (t1 - t0) + "ms");
            }
            else {
                l.setText(t1 - t0 + "ms");
            }
            countbool = false;
			//System.out.println("action performed on " + b.getText() + " button");
		}
	}

    static class MenuItemActionListener implements java.awt.event.ActionListener {
        // the menu item associated with the action listener, so that we can
        // share this one class with multiple menu items
        private javax.swing.JMenuItem m;
        
        MenuItemActionListener(javax.swing.JMenuItem m)
        {
            this.m = m;
        }

        public void actionPerformed(java.awt.event.ActionEvent e)
        {
            //System.out.println("action performed on " + m.getText() + " menu item");
            
            // if exit is selected from the file menu, exit the program
            if( m.getText().toLowerCase().equals("exit") )
            {
                System.exit(0);
            }
            
            // if color is selected from the edit menu, put a popup on the screen 
            // saying something 
            if( m.getText().toLowerCase().equals("read sort file") )
            {
                try {
                    readData(sortfilename, true);
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                
            }

            if( m.getText().toLowerCase().equals("read search file") )
            {
                try {
                    readData(searchfilename, false);
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        }
    }

    private static void readData(String filename, boolean readsort) throws IOException {
        try {
            java.io.BufferedReader input;
            input = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(filename)));
            java.util.ArrayList<Integer> tempenight = new java.util.ArrayList<>();
            String read;
            //java.util.ArrayList<Integer> hurm = new java.util.ArrayList<>();
            
            while((read = input.readLine()) != null) {
                tempenight.add(Integer.parseInt(read));
                
            }
            input.close();

            if (readsort == true) {
                sortVals = new int[tempenight.size()];
                for (int j = 0; j < tempenight.size(); j++) {
                    sortVals[j] = tempenight.get(j);
                }

                sortintsB.setEnabled(true);
                addbst.setEnabled(true);
                addtree.setEnabled(true);
                addpriq.setEnabled(true);
                addhash.setEnabled(true);
                addarrlis.setEnabled(true);
                addsortarrlis.setEnabled(true);
                addarr.setEnabled(true);
            }

            if (readsort == false) {
                searchVals = new int[tempenight.size()];
                for (int j = 0; j < tempenight.size(); j++) {
                    searchVals[j] = tempenight.get(j);
                }

                if (sortintbo) {
                    searchsortints.setEnabled(true);
                }
                if (bstbool) {
                    searchbst.setEnabled(true);
                }
                if (treebool) {
                    searchtree.setEnabled(true);
                }
                if (priqbool) {
                    searchpriq.setEnabled(true);
                }
                if (hashbool) {
                    searchhash.setEnabled(true);
                }
                if (arrlisbool) {
                    searcharrlis.setEnabled(true);
                }
                if (sortedarrlisbool) {
                    searchsortarrlis.setEnabled(true);
                }
                if (arrbool) {
                    searcharr.setEnabled(true);
                }

                else {
                    searched = true;
                }

            

            }
            
            
        } 
        catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        }
        
        
    }

    
    private static void selectionsort() {
        int dummy; //switch placeholder

        int[] copysortvals = new int[sortVals.length];
        //copysortvals = sortVals;
        for (int k = 0; k < sortVals.length; k++) {
            copysortvals[k] = sortVals[k];
        }
            
        for(int i = 0; i < sortVals.length; i++) {
    
            for(int j = i + 1; j < sortVals.length; j++) {
                
                if(copysortvals[j] < copysortvals[i]) {
                    dummy = copysortvals[i];
                    copysortvals[i] = copysortvals[j];
                    copysortvals[j] = dummy;

                }
            }
        }
    }

    private static void AddBinSearchTree() {
        //lol
        for (int i = 0; i < sortVals.length; i++) {
            bintreeset.add(sortVals[i]);
        }
    }

    private static void AddTreeSet() {
        for (int i = 0; i < sortVals.length; i++) {
            treesetvals.add(sortVals[i]);
        }
        //lmao even
    }
    
    private static void AddHashSet() {
        for (int i = 0; i < sortVals.length; i++) {
            hashsetvals.add(sortVals[i]);
        }
        //rofl
    }

    private static void AddPriQ() {
        for (int i = 0; i < sortVals.length; i++) {
            priQvals.add(sortVals[i]);
        }

    }

    private static void AddArrayList() {
        for (int i = 0; i < sortVals.length; i++) {
            arraylistvals.add(sortVals[i]);
        }

    }

    private static void AddSortedArrLis() {
        for (int i = 0; i < sortVals.length; i++) {
            sortedarrlisvals.add(sortVals[i]);
        }
        java.util.Collections.sort(sortedarrlisvals);
    }

    private static void AddArray() {
        int[] unsortedvals = new int[sortVals.length];
        for (int i = 0; i < sortVals.length; i++) {
            unsortedvals[i] = sortVals[i];
        }

    }

    //now for the right ones (search)
    private static int SearchInts() {
        int count = 0;
        for(int i = 0; i < searchVals.length; i++) {
            for (int j = 0; j < sortVals.length; j++) {
                if (sortVals[j] == searchVals[i]) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int SearchBinSearchTree() {
        int count = 0;
        for(int i = 0; i < bintreeset.size(); i++) {
            if(bintreeset.contains(searchVals[i])) {
                count++;
            }
        }
        return count;
    }

    private static int SearchTreeSet() {
        int count = 0;
        for(int i = 0; i < treesetvals.size(); i++) {
            if(treesetvals.contains(searchVals[i])) {
                count++;
            }
        }
        return count;
    }

    private static int SearchHashSet() {
        int count = 0;
        for(int i = 0; i < hashsetvals.size(); i++) {
            if(hashsetvals.contains(searchVals[i])) {
                count++;
            }
        }
        return count;
    }

    private static int SearchPriQ() {
        int count = 0;
        for(int i = 0; i < priQvals.size(); i++) {
            if(priQvals.contains(searchVals[i])) {
                count++;
            }
        }
        return count;
    }

    private static int SearchArrLis() {
        int count = 0;
        for(int i = 0; i < arraylistvals.size(); i++) {
            if(arraylistvals.contains(searchVals[i])) {
                count++;
            }
        }
        return count;
    }

    private static int SearchSortedArrLis() {
        int count = 0;
        for(int i = 0; i < sortedarrlisvals.size(); i++) {
            if(sortedarrlisvals.contains(searchVals[i])) {
                count++;
            }
        }
        return count;
    }

    private static int SearchArr() {
        int[] unsortedvals = new int[sortVals.length];
        for (int i = 0; i < sortVals.length; i++) {
            unsortedvals[i] = sortVals[i];
        }

        int count = 0;
        for(int i = 0; i < searchVals.length; i++) {
            //System.out.println("first for");
            //System.out.println(unsortedvals.length);
            for (int j = 0; j < unsortedvals.length; j++) {
                //System.out.println("second for");
                if (unsortedvals[j] == searchVals[i]) {
                    count++;
                    //System.out.println("count up");
                }
            }
        }
        return count;
    }
}

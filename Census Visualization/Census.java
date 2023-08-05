package safe;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Census extends JFrame{
    public static void main(String[] args) throws Exception {

        File sindhFile = new File("Sindh.dat");
        File punjabFile = new File("Punjab.dat");
        File kpkFile = new File("KPK.dat");
        File balochFile = new File("Balochistan.dat");
        File ictFile = new File("ICT.dat");
        File countryData = new File("Pakistan.dat");
        Pakistan pakistan = new Pakistan();
        Sindh Sindh1998 = new Sindh();
        Punjab Punjab1998 = new Punjab();
        Balochistan Balochistan1998 = new Balochistan();
        KPK KPK1998 = new KPK();
        ICT ICT1998 = new ICT();






        //2017 data
        Sindh Sindh2017 = new Sindh();
        Sindh2017.setYear(2017);
        Sindh2017.stats.setMalePopulation(24927046);
        Sindh2017.stats.setFemalePopulation(22956478);
        Sindh2017.stats.setSexRatio(Sindh2017.calculateSexRatio());
        Sindh2017.stats.setPopPerSquareKM(Sindh2017.calculatePopDensity());
        Sindh2017.stats.setPopulationGrowth(Sindh2017.calculatePopGrowth(Sindh1998, Sindh2017));


        Punjab Punjab2017 = new Punjab();
        Punjab2017.setYear(2017);
        Punjab2017.stats.setMalePopulation(55958974);
        Punjab2017.stats.setFemalePopulation(54046759);
        Punjab2017.stats.setSexRatio(Punjab2017.calculateSexRatio());
        Punjab2017.stats.setPopPerSquareKM(Punjab2017.calculatePopDensity());
        Punjab2017.stats.setPopulationGrowth(Punjab2017.calculatePopGrowth(Punjab1998, Punjab2017));

        Balochistan Balochistan2017 = new Balochistan();
        Balochistan2017.setYear(2017);
        Balochistan2017.stats.setMalePopulation(6480814);
        Balochistan2017.stats.setFemalePopulation(5863593);
        Balochistan2017.stats.setSexRatio(Balochistan2017.calculateSexRatio());
        Balochistan2017.stats.setPopPerSquareKM(Balochistan2017.calculatePopDensity());
        Balochistan2017.stats.setPopulationGrowth(Balochistan2017.calculatePopGrowth(Balochistan1998, Balochistan2017));

        KPK KPK2017 = new KPK();
        KPK2017.setYear(2017);
        KPK2017.stats.setMalePopulation(15467645);
        KPK2017.stats.setFemalePopulation(15054813);
        KPK2017.stats.setSexRatio(KPK2017.calculateSexRatio());
        KPK2017.stats.setPopPerSquareKM(KPK2017.calculatePopDensity());
        KPK2017.stats.setPopulationGrowth(KPK2017.calculatePopGrowth(KPK1998, KPK2017));

        ICT ICT2017 = new ICT();
        ICT2017.setYear(2017);
        ICT2017.stats.setMalePopulation(1025290);
        ICT2017.stats.setFemalePopulation(981282);
        ICT2017.stats.setSexRatio(ICT2017.calculateSexRatio());
        ICT2017.stats.setPopPerSquareKM(ICT2017.calculatePopDensity());
        ICT2017.stats.setPopulationGrowth(ICT2017.calculatePopGrowth(ICT1998, ICT2017));


//        pakistan.display();

        /*FileOutputStream sindhCensus = new FileOutputStream(sindhFile);
        ObjectOutputStream sindhOutputStream = new ObjectOutputStream(sindhCensus);
        sindhOutputStream.writeObject(Sindh1998);
        sindhOutputStream.writeObject(Sindh2017);

        FileOutputStream punjabCensus = new FileOutputStream(punjabFile);
        ObjectOutputStream punjabOutputStream = new ObjectOutputStream(punjabCensus);
        punjabOutputStream.writeObject(Punjab1998);
        punjabOutputStream.writeObject(Punjab2017);

        FileOutputStream balochCensus = new FileOutputStream(balochFile);
        ObjectOutputStream balochOutputStream = new ObjectOutputStream(balochCensus);
        balochOutputStream.writeObject(Balochistan1998);
        balochOutputStream.writeObject(Balochistan2017);

        FileOutputStream kpkCensus = new FileOutputStream(kpkFile);
        ObjectOutputStream kpkOutputStream = new ObjectOutputStream(kpkCensus);
        kpkOutputStream.writeObject(KPK1998);
        kpkOutputStream.writeObject(KPK2017);

        FileOutputStream ictCensus = new FileOutputStream(ictFile);
        ObjectOutputStream ictOutputStream = new ObjectOutputStream(ictCensus);
        ictOutputStream.writeObject(ICT1998);
        ictOutputStream.writeObject(ICT2017);

        FileOutputStream countryFile = new FileOutputStream(countryData);
        ObjectOutputStream countryOutputStream = new ObjectOutputStream(countryFile);
        countryOutputStream.writeObject(pakistan);*/

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        Font font = new Font("Poppins", Font.ITALIC, 12);
        Font titleFont = new Font("Rockwell", Font.BOLD, 20);
        JLabel sindhDivide = new JLabel("=".repeat(25));
        sindhDivide.setFont(titleFont);
        JLabel punjabDivide = new JLabel("=".repeat(25));
        punjabDivide.setFont(titleFont);
        JLabel balochDivide = new JLabel("=".repeat(25));
        balochDivide.setFont(titleFont);
        JLabel kpkDivide = new JLabel("=".repeat(25));
        kpkDivide.setFont(titleFont);
        JLabel ictDivide = new JLabel("=".repeat(25));
        ictDivide.setFont(titleFont);
        JLabel imgLabel = new JLabel(new ImageIcon("D:\\COMSATS\\Semester III\\CSC241 - Object Oriented Programming\\Semester Project\\main.png"));
        imgLabel.setSize(3,3);


        //main menu frame testing 1 - clear

        JFrame mainMenu = new JFrame("Census Visualizer");
        mainMenu.setSize(400,250);
        mainMenu.setLayout(new FlowLayout());
        mainMenu.setLocationRelativeTo(null);
        mainMenu.setResizable(false);
        mainMenu.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel menuLabel = new JLabel("<html>Choose an operation<BR>");
        JPanel menuPanel = new JPanel();
        menuLabel.setFont(titleFont);
        menuPanel.add(menuLabel);
//        menuLabel.add(imgLabel);

        JButton addButton = new JButton("Add new census data");
        addButton.setFont(font);
        JButton viewButton = new JButton("View previous census data");
        viewButton.setFont(font);
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(viewButton);
        mainMenu.add(imgLabel);
        mainMenu.add(menuPanel);
        mainMenu.add(buttonPanel);

        //ADD SECTION TESTING COMPLETE
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //add new data menu testing 1 - clear

                JFrame addFrame = new JFrame("New census data collection");
                addFrame.setSize(400,150);
                addFrame.setLayout(new FlowLayout());
                addFrame.setResizable(false);
                addFrame.setLocationRelativeTo(null);
                addFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                JLabel provinceLabel = new JLabel("<html>Select a province<BR>");
                JPanel titlePanel = new JPanel();
                provinceLabel.setFont(titleFont);
                titlePanel.add(provinceLabel);

                JPanel addButtonPanel = new JPanel(new FlowLayout());
                JButton sindhB = new JButton("Sindh");
                sindhB.setFont(font);
                JButton punjabB = new JButton("Punjab");
                punjabB.setFont(font);
                JButton baloB = new JButton("Balochistan");
                baloB.setFont(font);
                JButton kpkB = new JButton("KPK");
                kpkB.setFont(font);
                JButton ictB = new JButton("ICT");
                ictB.setFont(font);
                addButtonPanel.add(sindhB);
                addButtonPanel.add(punjabB);
                addButtonPanel.add(baloB);
                addButtonPanel.add(kpkB);
                addButtonPanel.add(ictB);

                addFrame.add(titlePanel);
                addFrame.add(addButtonPanel);

                sindhB.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // adding new census data section
                        // sindh new census data menu testing 1 - clear
                        // sindh new census data menu testing 2 - clear

                        JFrame sindhFrame = new JFrame("Sindh ");
                        sindhFrame.setSize(350, 510);
                        sindhFrame.setLayout(new FlowLayout());
                        sindhFrame.setResizable(false);
                        sindhFrame.setLocationRelativeTo(null);
                        sindhFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                        JLabel sindh2022 = new JLabel("<html>Sindh Census for 2022<BR>"); //province.getName / province.getYear
                        JPanel sindhPanel = new JPanel();
                        sindh2022.setFont(titleFont);
                        sindhPanel.add(sindh2022);

                        JLabel sindhMaleP = new JLabel("Enter male population");
                        sindhMaleP.setFont(font);
                        JLabel sindhfemaleP = new JLabel("Enter female population");
                        sindhfemaleP.setFont(font);
                        JTextField sindhMaleF = new JTextField(12);
                        JTextField sindhFemaleF = new JTextField(12);



                        JPanel sindhMalePanel = new JPanel(new FlowLayout());
                        JPanel sindhFemalePanel = new JPanel(new FlowLayout());
                        sindhMalePanel.add(sindhMaleP);
                        sindhMalePanel.add(sindhMaleF);
                        sindhFemalePanel.add(sindhfemaleP);
                        sindhFemalePanel.add(sindhFemaleF);

                        JButton sindhSubmit = new JButton("Enter");
                        sindhSubmit.setFont(font);
                        JPanel panel1 = new JPanel();
                        panel1.add(sindhSubmit);

                        JButton sindhBackToMain = new JButton("Back to the main menu.");
                        sindhBackToMain.setFont(font);

                        sindhBackToMain.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                mainMenu.setVisible(true);
                                sindhFrame.dispose();
                                addFrame.dispose();
                            }
                        });

                        sindhSubmit.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                                JOptionPane.showMessageDialog(sindhFrame, "Proceed to view", "New census data successfully added", JOptionPane.INFORMATION_MESSAGE);
                                Sindh Sindh2022 = new Sindh();
                                Sindh2022.setYear(2022);

                                int malePopulation = Integer.parseInt(sindhMaleF.getText());
                                int femalePopulation = Integer.parseInt(sindhFemaleF.getText());

                                Sindh2022.stats.setMalePopulation(malePopulation);
                                Sindh2022.stats.setFemalePopulation(femalePopulation);
                                Sindh2022.stats.setSexRatio(Sindh2022.calculateSexRatio());
                                Sindh2022.stats.setPopPerSquareKM(Sindh2022.calculatePopDensity());
                                Sindh2022.stats.setPopulationGrowth(Sindh2022.calculatePopGrowth(Sindh2017,Sindh2022));

                                Sindh2022.populationYears.add(2022);
                                Sindh.population.add(malePopulation+femalePopulation);

                                JTextArea sindhNewData = new JTextArea(12, 30);
                                String temp3 = Sindh2022.toString();
                                sindhNewData.append(temp3);
                                sindhNewData.setEditable(false);
                                JScrollPane sindhNewDataPane = new JScrollPane(sindhNewData);
                                sindhNewDataPane.setSize(250, 550);
                                sindhFrame.add(sindhNewDataPane);
                                sindhFrame.add(sindhBackToMain);
                                sindhFrame.setVisible(true);

                                try {
                                    FileOutputStream fileOutputStream = new FileOutputStream(sindhFile,true);
                                    ObjectOutputStream objectOutputStream = new MyObjectOutputStream(fileOutputStream);
                                    objectOutputStream.writeObject(Sindh2022);
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                            }
                        });

                        sindhFrame.add(sindhPanel);
                        sindhFrame.add(sindhMalePanel);
                        sindhFrame.add(sindhFemalePanel);
                        sindhFrame.add(panel1);
                        sindhFrame.add(sindhDivide);
                        sindhFrame.setVisible(true);
                    }
                });

                punjabB.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //punjab new census data menu testing 1 - clear
                        //punjab new census data menu testing 2 - clear

                        JFrame punjabFrame = new JFrame("Punjab ");
                        punjabFrame.setSize(350,510);
                        punjabFrame.setLayout(new FlowLayout());
                        punjabFrame.setResizable(false);
                        punjabFrame.setLocationRelativeTo(null);
                        punjabFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                        JLabel punjab2022 = new JLabel("<html>Punjab Census for 2022<BR>"); //province.getName / province.getYear
                        JPanel punjabPanel = new JPanel();
                        punjab2022.setFont(titleFont);
                        punjabPanel.add(punjab2022);

                        JLabel punjabMaleP = new JLabel("Enter male population");
                        punjabMaleP.setFont(font);
                        JLabel punjabFemaleP = new JLabel("Enter female population");
                        punjabFemaleP.setFont(font);
                        JTextField punjabMaleF = new JTextField(12);
                        JTextField punjabFemaleF = new JTextField(12);
                        JPanel punjabMalePanel = new JPanel(new FlowLayout());
                        JPanel punjabFemalePanel = new JPanel(new FlowLayout());
                        punjabMalePanel.add(punjabMaleP);
                        punjabMalePanel.add(punjabMaleF);
                        punjabFemalePanel.add(punjabFemaleP);
                        punjabFemalePanel.add(punjabFemaleF);

                        JButton punjabSubmit = new JButton("Enter");
                        punjabSubmit.setFont(font);
                        JPanel panel2 = new JPanel();
                        panel2.add(punjabSubmit);

                        punjabSubmit.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                                JOptionPane.showMessageDialog(punjabFrame, "Proceed to view", "New census data successfully added", JOptionPane.INFORMATION_MESSAGE);
                                Punjab Punjab2022 = new Punjab();
                                Punjab2022.setYear(2022);

                                int malePopulation = Integer.parseInt(punjabMaleF.getText());
                                int femalePopulation = Integer.parseInt(punjabFemaleF.getText());

                                Punjab2022.stats.setMalePopulation(malePopulation);
                                Punjab2022.stats.setFemalePopulation(femalePopulation);
                                Punjab2022.stats.setSexRatio(Punjab2022.calculateSexRatio());
                                Punjab2022.stats.setPopPerSquareKM(Punjab2022.calculatePopDensity());
                                Punjab2022.stats.setPopulationGrowth(Punjab2022.calculatePopGrowth(Punjab2017,Punjab2022));

                                Punjab2022.populationYears.add(2022);
                                Punjab.population.add(malePopulation+femalePopulation);

                                JButton punjabBackToMain = new JButton("Back to the main menu.");
                                punjabBackToMain.setFont(font);

                                punjabBackToMain.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                        mainMenu.setVisible(true);
                                        punjabFrame.dispose();
                                    }
                                });

                                JTextArea punjabNewData = new JTextArea(12, 30);
                                String temp3 = Punjab2022.toString();
                                punjabNewData.append(temp3);
                                punjabNewData.setEditable(false);
                                JScrollPane punjabNewDataPane = new JScrollPane(punjabNewData);
                                punjabNewDataPane.setSize(250, 550);
                                punjabFrame.add(punjabNewDataPane);
                                punjabFrame.add(punjabBackToMain);
                                punjabFrame.setVisible(true);

                                try {
                                    FileOutputStream fileOutputStream = new FileOutputStream(punjabFile,true);
                                    ObjectOutputStream objectOutputStream = new MyObjectOutputStream(fileOutputStream);
                                    objectOutputStream.writeObject(Punjab2022);
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                            }
                        });


                        punjabFrame.add(punjabPanel);
                        punjabFrame.add(punjabMalePanel);
                        punjabFrame.add(punjabFemalePanel);
                        punjabFrame.add(panel2);
                        punjabFrame.add(punjabDivide);
                        punjabFrame.setVisible(true);

                    }
                });

                baloB.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // balochistan new census data menu testing 1 - clear
                        // balochistan new census data menu testing 2 - clear

                        JFrame balochistanFrame = new JFrame("Balochistan ");
                        balochistanFrame.setSize(350,510);
                        balochistanFrame.setLayout(new FlowLayout());
                        balochistanFrame.setResizable(false);
                        balochistanFrame.setLocationRelativeTo(null);
                        balochistanFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                        JLabel balochistan2022 = new JLabel("<html>Balochistan Census for 2022<BR>"); //province.getName / province.getYear
                        JPanel balochistanPanel = new JPanel();
                        balochistan2022.setFont(titleFont);
                        balochistanPanel.add(balochistan2022);

                        JLabel balochistanMaleP = new JLabel("Enter male population");
                        balochistanMaleP.setFont(font);
                        JLabel balochistanFemaleP = new JLabel("Enter female population");
                        balochistanFemaleP.setFont(font);

                        JTextField balochistanMaleF = new JTextField(12);
                        JTextField balochistanFemaleF = new JTextField(12);
                        JPanel balochMalePanel = new JPanel(new FlowLayout());
                        JPanel balochFemalePanel = new JPanel(new FlowLayout());
                        balochMalePanel.add(balochistanMaleP);
                        balochMalePanel.add(balochistanMaleF);
                        balochFemalePanel.add(balochistanFemaleP);
                        balochFemalePanel.add(balochistanFemaleF);

                        JButton balochSubmit = new JButton("Enter");
                        balochSubmit.setFont(font);
                        JPanel panel3 = new JPanel();
                        panel3.add(balochSubmit);

                        balochSubmit.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                                JOptionPane.showMessageDialog(balochistanFrame, "Proceed to view", "New census data successfully added", JOptionPane.INFORMATION_MESSAGE);
                                Balochistan Balochistan2022 = new Balochistan();

                                int malePopulation = Integer.parseInt(balochistanMaleF.getText());
                                int femalePopulation = Integer.parseInt(balochistanFemaleF.getText());

                                Balochistan2022.setYear(2022);
                                Balochistan2022.stats.setMalePopulation(malePopulation);
                                Balochistan2022.stats.setFemalePopulation(femalePopulation);
                                Balochistan2022.stats.setSexRatio(Balochistan2022.calculateSexRatio());
                                Balochistan2022.stats.setPopPerSquareKM(Balochistan2022.calculatePopDensity());
                                Balochistan2022.stats.setPopulationGrowth(Balochistan2022.calculatePopGrowth(Balochistan1998,Balochistan2022));

                                Balochistan2022.populationYears.add(2022);
                                Balochistan.population.add(malePopulation+femalePopulation);

                                JButton balochBackToMain = new JButton("Back to the main menu.");
                                balochBackToMain.setFont(font);

                                balochBackToMain.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                        mainMenu.setVisible(true);
                                        balochistanFrame.dispose();
                                        addFrame.dispose();
                                    }
                                });

                                JTextArea balochNewData = new JTextArea(12, 30);
                                String temp3 = Balochistan2022.toString();
                                balochNewData.append(temp3);
                                balochNewData.setEditable(false);
                                JScrollPane balochNewDataFrame = new JScrollPane(balochNewData);
                                balochNewDataFrame.setSize(250, 550);
                                balochistanFrame.add(balochNewDataFrame);
                                balochistanFrame.add(balochBackToMain);
                                balochistanFrame.setVisible(true);

                                try {
                                    FileOutputStream fileOutputStream = new FileOutputStream(balochFile,true);
                                    ObjectOutputStream objectOutputStream = new MyObjectOutputStream(fileOutputStream);
                                    objectOutputStream.writeObject(Balochistan2022);
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                            }
                        });

                        balochistanFrame.add(balochistanPanel);
                        balochistanFrame.add(balochMalePanel);
                        balochistanFrame.add(balochFemalePanel);
                        balochistanFrame.add(panel3);
                        balochistanFrame.add(balochDivide);
                        balochistanFrame.setVisible(true);
                    }
                });

                kpkB.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //kpk new census data menu testing 1 - clear
                        //kpk new census data menu testing 2 - clear

                        JFrame kpkFrame = new JFrame("Khyber Pakhtunkhwa");
                        kpkFrame.setSize(350,510);
                        kpkFrame.setLayout(new FlowLayout());
                        kpkFrame.setResizable(false);
                        kpkFrame.setLocationRelativeTo(null);
                        kpkFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                        JLabel kpk2022 = new JLabel("<html>KPK Census for 2022<BR>"); //province.getName / province.getYear
                        JPanel kpkPanel = new JPanel();
                        kpk2022.setFont(titleFont);
                        kpkPanel.add(kpk2022);

                        JLabel kpkMaleP = new JLabel("Enter male population");
                        kpkMaleP.setFont(font);
                        JLabel kpkFemaleP = new JLabel("Enter female population");
                        kpkFemaleP.setFont(font);

                        JTextField kpkMaleF = new JTextField(12);
                        JTextField kpkFemaleF = new JTextField(12);
                        JPanel kpkMalePanel = new JPanel(new FlowLayout());
                        JPanel kpkFemalePanel = new JPanel(new FlowLayout());
                        kpkMalePanel.add(kpkMaleP);
                        kpkMalePanel.add(kpkMaleF);
                        kpkFemalePanel.add(kpkFemaleP);
                        kpkFemalePanel.add(kpkFemaleF);

                        JButton kpkSubmit = new JButton("Enter");
                        kpkSubmit.setFont(font);
                        JPanel panel4 = new JPanel();
                        panel4.add(kpkSubmit);

                        kpkSubmit.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                                JOptionPane.showMessageDialog(kpkFrame, "Proceed to view", "New census data successfully added", JOptionPane.INFORMATION_MESSAGE);
                                KPK KPK2022 = new KPK();

                                int malePopulation = Integer.parseInt(kpkMaleF.getText());
                                int femalePopulation = Integer.parseInt(kpkFemaleF.getText());

                                KPK2022.setYear(2022);
                                KPK2022.stats.setMalePopulation(malePopulation);
                                KPK2022.stats.setFemalePopulation(femalePopulation);
                                KPK2022.stats.setSexRatio(KPK2022.calculateSexRatio());
                                KPK2022.stats.setPopPerSquareKM(KPK2022.calculatePopDensity());
                                KPK2022.stats.setPopulationGrowth(KPK1998.calculatePopGrowth(KPK2017,KPK2022));

                                KPK2022.populationYears.add(2022);
                                KPK.population.add(malePopulation+femalePopulation);

                                JButton kpkBackToMain = new JButton("Back to the main menu.");
                                kpkBackToMain.setFont(font);

                                kpkBackToMain.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                        mainMenu.setVisible(true);
                                        kpkFrame.dispose();
                                        addFrame.dispose();
                                    }
                                });

                                JTextArea kpkNewData = new JTextArea(12, 30);
                                String temp3 = KPK2022.toString();
                                kpkNewData.append(temp3);
                                kpkNewData.setEditable(false);
                                JScrollPane kpkNewDataFrame = new JScrollPane(kpkNewData);
                                kpkNewDataFrame.setSize(250, 550);
                                kpkFrame.add(kpkNewDataFrame);
                                kpkFrame.add(kpkBackToMain);
                                kpkFrame.setVisible(true);

                                try {
                                    FileOutputStream fileOutputStream = new FileOutputStream(kpkFile,true);
                                    ObjectOutputStream objectOutputStream = new MyObjectOutputStream(fileOutputStream);
                                    objectOutputStream.writeObject(KPK2022);
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                            }
                        });

                        kpkFrame.add(kpkPanel);
                        kpkFrame.add(kpkMalePanel);
                        kpkFrame.add(kpkFemalePanel);
                        kpkFrame.add(panel4);
                        kpkFrame.add(kpkDivide);
                        kpkFrame.setVisible(true);
                    }
                });


                ictB.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        //ict new census data testing 1 - clear
                        //ict new census data testing 2 - clear

                        JFrame ictFrame = new JFrame("Islamabad Capital Territory ");
                        ictFrame.setSize(350,510);
                        ictFrame.setLayout(new FlowLayout());
                        ictFrame.setResizable(false);
                        ictFrame.setLocationRelativeTo(null);
                        ictFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                        JLabel ict2022 = new JLabel("<html>ICT Census for 2022<BR>"); //province.getName / province.getYear
                        JPanel ictPanel = new JPanel();
                        ict2022.setFont(titleFont);
                        ictPanel.add(ict2022);

                        JLabel ictMaleP = new JLabel("Enter male population");
                        ictMaleP.setFont(font);
                        JLabel ictFemaleP = new JLabel("Enter female population");
                        ictFemaleP.setFont(font);

                        JTextField ictMaleF = new JTextField(12);
                        JTextField ictFemaleF = new JTextField(12);
                        JPanel ictMalePanel = new JPanel(new FlowLayout());
                        JPanel ictFemalePanel = new JPanel(new FlowLayout());
                        ictMalePanel.add(ictMaleP);
                        ictMalePanel.add(ictMaleF);
                        ictFemalePanel.add(ictFemaleP);
                        ictFemalePanel.add(ictFemaleF);

                        JButton ictSubmit = new JButton("Enter");
                        ictSubmit.setFont(font);
                        JPanel panel5 = new JPanel();
                        panel5.add(ictSubmit);

                        ictSubmit.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                                ICT ICT2022 = new ICT();
                                JOptionPane.showMessageDialog(ictFrame, "Proceed to view", "New census data successfully added", JOptionPane.INFORMATION_MESSAGE);

                                int malePopulation = Integer.parseInt(ictMaleF.getText());
                                int femalePopulation = Integer.parseInt(ictFemaleF.getText());

                                ICT2022.setYear(2022);
                                ICT2022.stats.setMalePopulation(malePopulation);
                                ICT2022.stats.setFemalePopulation(femalePopulation);
                                ICT2022.stats.setSexRatio(ICT2022.calculateSexRatio());
                                ICT2022.stats.setPopPerSquareKM(ICT2022.calculatePopDensity());
                                ICT2022.stats.setPopulationGrowth(ICT2022.calculatePopGrowth(ICT1998,ICT2022));

                                ICT2022.populationYears.add(2022);
                                ICT.population.add(malePopulation+femalePopulation);

                                JButton ictBackToMain = new JButton("Back to the main menu.");
                                ictBackToMain.setFont(font);

                                ictBackToMain.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                        mainMenu.setVisible(true);
                                        ictFrame.dispose();
                                        addFrame.dispose();
                                    }
                                });

                                JTextArea ictNewData = new JTextArea(12, 30);
                                String temp3 = ICT2022.toString();
                                ictNewData.append(temp3);
                                ictNewData.setEditable(false);
                                JScrollPane ictNewDataPane = new JScrollPane(ictNewData);
                                ictNewDataPane.setSize(250, 550);
                                ictFrame.add(ictNewDataPane);
                                ictFrame.add(ictBackToMain);
                                ictFrame.setVisible(true);

                                try {
                                    FileOutputStream fileOutputStream = new FileOutputStream(ictFile,true);
                                    ObjectOutputStream objectOutputStream = new MyObjectOutputStream(fileOutputStream);
                                    objectOutputStream.writeObject(ICT2022);
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                            }
                        });

                        ictFrame.add(ictPanel);
                        ictFrame.add(ictMalePanel);
                        ictFrame.add(ictFemalePanel);
                        ictFrame.add(panel5);
                        ictFrame.add(ictDivide);
                        ictFrame.setVisible(true);
                    }
                });
                addFrame.setVisible(true);
            }
        });

        //VIEW SECTION TESTING COMPLETE
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //view prev data menu testing 1 - clear

                JFrame viewFrame = new JFrame("View previous statistics");
                viewFrame.setSize(400,150);
                viewFrame.setLayout(new FlowLayout());
                viewFrame.setResizable(false);
                viewFrame.setLocationRelativeTo(null);
                viewFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

                JLabel viewLabel = new JLabel("<html>Select statistical category<BR>");
                JPanel oldViewPanel = new JPanel();
                viewLabel.setFont(titleFont);
                oldViewPanel.add(viewLabel);

                JPanel oldButtonPanel = new JPanel(new FlowLayout());
                JButton countryB = new JButton("Country");
                JButton provinceB = new JButton("Province");
                countryB.setFont(new Font("Poppins",Font.ITALIC,16));
                provinceB.setFont(new Font("Poppins",Font.ITALIC,16));
                oldButtonPanel.add(countryB);
                oldButtonPanel.add(provinceB);

                viewFrame.add(oldViewPanel);
                viewFrame.add(oldButtonPanel);

                //viewing previous country statistics //COMPLETE
                countryB.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //country statistics section
                        // testing 1 - clear

                        JFrame countryStatsFrame = new JFrame("Country wide statistics");
                        countryStatsFrame.setSize(500, 350);
                        countryStatsFrame.setLayout(new FlowLayout());
                        countryStatsFrame.setResizable(false);
                        countryStatsFrame.setLocationRelativeTo(null);
                        countryStatsFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                        JLabel countryStatsTitle = new JLabel("<html>Country Statistics by 2022<BR>");
                        countryStatsTitle.setFont(titleFont);

                        JTextArea countryStatsArea = new JTextArea(12, 45);
                        Pakistan pakistanTemp;
                        try {
                            FileInputStream fis = new FileInputStream(countryData);
                            ObjectInputStream ois = new ObjectInputStream(fis);
                            try{
                                while(fis.available()!= 0){
                                    pakistanTemp = (Pakistan) ois.readObject();
                                    String var = pakistanTemp.toString();
                                    countryStatsArea.append(var);
                                }

                            } catch (ClassNotFoundException ex) {
                                ex.printStackTrace();
                            }

                        } catch (IOException ex ) {
                            ex.printStackTrace();
                        }

                        JScrollPane countryScroll = new JScrollPane(countryStatsArea);
                        countryScroll.setSize(300, 125);

                        countryStatsFrame.add(countryStatsTitle);
                        countryStatsFrame.add(countryScroll);
                        countryStatsFrame.setVisible(true);

                        ArrayList<Integer> populationYears = pakistan.getPopulationYears();
                        ArrayList<Integer> countryPopulation = pakistan.getCountryPopulation();

                        ArrayList<Double> unemploymentRates = pakistan.getUnemploymentRates();
                        ArrayList<Integer> unemploymentYears = pakistan.getUnemploymentYears();


                        JFrame countryGraphPopulation = new JFrame("Population Growth");
                        countryGraphPopulation.setAlwaysOnTop(true);
                        countryGraphPopulation.setResizable(false);
                        countryGraphPopulation.pack();
                        countryGraphPopulation.setLocationRelativeTo(countryStatsFrame);
                        countryGraphPopulation.setSize(900, 400);
                        countryGraphPopulation.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                        countryGraphPopulation.setVisible(true);

                        DefaultCategoryDataset countryPopulationDataset = new DefaultCategoryDataset();
                        String series1 = "Population";
                        for(int i = 0; i < populationYears.size(); i++){
                            countryPopulationDataset.addValue(countryPopulation.get(i),series1,populationYears.get(i));
                        }
                        String chartTitle = "Population growth 1951-2022";
                        String categoryAxisLabel = "Pakistan";
                        String valueAxisLabel = "Population";

                        JFreeChart chart = ChartFactory.createLineChart(chartTitle, categoryAxisLabel, valueAxisLabel, countryPopulationDataset);

                        ChartPanel countryPop = new ChartPanel(chart);

                        JFrame countryGraphUnemployment = new JFrame("Unemployment Rates");
                        countryGraphUnemployment.setAlwaysOnTop(true);
                        countryGraphUnemployment.setResizable(false);
//                        countryGraphUnemployment.setLocationRelativeTo(countryStatsFrame);
                        countryGraphUnemployment.pack();
                        countryGraphUnemployment.setSize(700, 400);
                        countryGraphUnemployment.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                        countryGraphUnemployment.setVisible(true);

                        DefaultCategoryDataset empDataset = new DefaultCategoryDataset();
                        String series2 = "Unemployment Rates";
                        for(int i = 0; i < unemploymentYears.size(); i++){
                            empDataset.addValue(unemploymentRates.get(i),series2,unemploymentYears.get(i));
                        }
                        String empChartTitle = "Unemployment rates from 1951-2022";
                        String empCategoryAxisLabel = "Pakistan";
                        String empValueAxisLabel = "Unemployment %";

                        JFreeChart unemploymentChart = ChartFactory.createLineChart(empChartTitle, empCategoryAxisLabel, empValueAxisLabel, empDataset);

                        ChartPanel countryEmp = new ChartPanel(unemploymentChart);

                        JButton countryBackToMain = new JButton("Back to the main menu.");
                        countryBackToMain.setFont(font);

                        countryBackToMain.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                mainMenu.setVisible(true);
                                countryGraphUnemployment.dispose();
                                countryGraphPopulation.dispose();
                                countryStatsFrame.dispose();
                                viewFrame.dispose();
                            }
                        });

                        countryStatsFrame.add(countryBackToMain);
                        countryGraphPopulation.add(countryPop);
                        countryGraphPopulation.setVisible(true);
                        countryGraphUnemployment.add(countryEmp);
                        countryGraphUnemployment.setVisible(true);
                    }
                });

                provinceB.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //province statistics sections
                        //view old census menu testing 1 - clear

                        JFrame viewProvinceFrame = new JFrame("Reviewing previous census data");
                        viewProvinceFrame.setSize(400,150);
                        viewProvinceFrame.setLayout(new FlowLayout());
                        viewProvinceFrame.setResizable(false);
                        viewProvinceFrame.setLocationRelativeTo(null);
                        viewProvinceFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                        JLabel viewProvinceLabel = new JLabel("<html>Select a province<BR>");
                        JPanel viewTitlePanel = new JPanel();
                        viewProvinceLabel.setFont(titleFont);
                        viewTitlePanel.add(viewProvinceLabel);

                        JPanel viewButtonPanel = new JPanel(new FlowLayout());
                        JButton viewSindhB = new JButton("Sindh");
                        viewSindhB.setFont(font);
                        JButton viewPunjabB = new JButton("Punjab");
                        viewPunjabB.setFont(font);
                        JButton viewBalochB = new JButton("Balochistan");
                        viewBalochB.setFont(font);
                        JButton viewKPKB = new JButton("KPK");
                        viewKPKB.setFont(font);
                        JButton viewICTB = new JButton("ICT");
                        viewICTB.setFont(font);

                        viewButtonPanel.add(viewSindhB);
                        viewButtonPanel.add(viewPunjabB);
                        viewButtonPanel.add(viewBalochB);
                        viewButtonPanel.add(viewKPKB);
                        viewButtonPanel.add(viewICTB);

                        viewProvinceFrame.add(viewTitlePanel);
                        viewProvinceFrame.add(viewButtonPanel);

                        //sindh old data
                        viewSindhB.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                //viewing old data section
                                //sindh view census data testing 1 - clear

                                JFrame sindhStatsFrame = new JFrame("Previous Data");
                                JFrame sindhGraph = new JFrame("Sindh Graph");
                                sindhGraph.setTitle("Sindh");
                                sindhGraph.setAlwaysOnTop(true);
                                sindhGraph.pack();
                                sindhGraph.setSize(600, 400);
                                sindhGraph.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

                                JButton sindhBackToMain = new JButton("Back to the main menu.");
                                sindhBackToMain.setFont(font);

                                sindhBackToMain.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                        mainMenu.setVisible(true);
                                        sindhGraph.dispose();
                                        sindhStatsFrame.dispose();
                                        viewProvinceFrame.dispose();
                                        viewFrame.dispose();

                                    }
                                });

                                sindhStatsFrame.setSize(500,570);
                                sindhStatsFrame.setLayout(new FlowLayout());
                                sindhStatsFrame.setResizable(false);
                                sindhStatsFrame.setAlwaysOnTop(true);
                                sindhStatsFrame.setLocationRelativeTo(null);
                                sindhStatsFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

                                DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                                String series1 = "Population";
                                ArrayList<Integer> populationYears = Sindh1998.getPopulationYears();
                                ArrayList<Integer> population = Sindh1998.getPopulation();

                                for(int i = 0; i < population.size(); i++){
                                    dataset.addValue(population.get(i),series1,populationYears.get(i));
                                }


                                String chartTitle = "Population growth for Sindh";
                                String categoryAxisLabel = "Sindh";
                                String valueAxisLabel = "Population";

                                JFreeChart chart = ChartFactory.createLineChart(chartTitle, categoryAxisLabel, valueAxisLabel, dataset);

                                ChartPanel newChart = new ChartPanel(chart);

                                JLabel sindhStatsTitle = new JLabel("<html>Major census data<BR>");
                                sindhStatsTitle.setFont(titleFont);
                                JTextArea sindhStatsArea = new JTextArea(25,50);

                                //test run data

                                Sindh sindhTemp;
                                try {
                                    FileInputStream fis = new FileInputStream(sindhFile);
                                    ObjectInputStream ois = new ObjectInputStream(fis);
                                    try{
                                        while(fis.available()!= 0){
                                            sindhTemp = (Sindh) ois.readObject();
                                            String var = sindhTemp.toString();
                                            sindhStatsArea.append(var);
                                        }

                                    } catch (ClassNotFoundException ex) {
                                        ex.printStackTrace();
                                    }

                                } catch (IOException ex ) {
                                    ex.printStackTrace();
                                }

                                JScrollPane sindhScrollPane = new JScrollPane(sindhStatsArea);
                                sindhScrollPane.setSize(700,150);
                                sindhStatsFrame.add(sindhStatsTitle);
                                sindhStatsFrame.add(sindhScrollPane);
                                sindhStatsFrame.add(sindhBackToMain);
                                sindhStatsFrame.setVisible(true);
                                sindhGraph.add(newChart);
                                sindhGraph.setVisible(true);
                            }
                        });

                        //punjab old data

                        viewPunjabB.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                //punjab view census data testing 1 - clear

                                JFrame punjabStatsFrame = new JFrame("Previous Data");
                                punjabStatsFrame.setSize(500,550);
                                punjabStatsFrame.setLayout(new FlowLayout());
                                punjabStatsFrame.setResizable(false);
                                punjabStatsFrame.setLocationRelativeTo(null);
                                punjabStatsFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                                JButton backToMain = new JButton("Back to the main menu.");
                                backToMain.setFont(font);

                                JFrame punjabGraph = new JFrame("Punjab Graph");
                                punjabGraph.setTitle("Punjab");
                                punjabGraph.setAlwaysOnTop(true);
                                punjabGraph.pack();
                                punjabGraph.setSize(600, 400);
                                punjabGraph.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

                                JButton punjabBackToMain = new JButton("Back to the main menu.");
                                punjabBackToMain.setFont(font);

                                punjabBackToMain.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                        mainMenu.setVisible(true);
                                        punjabGraph.dispose();
                                        punjabStatsFrame.dispose();
                                        viewProvinceFrame.dispose();
                                        viewFrame.dispose();
                                    }
                                });

                                DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                                String series1 = "Population";
                                ArrayList<Integer> populationYears = Punjab1998.getPopulationYears();
                                ArrayList<Integer> population = Punjab1998.getPopulation();
                                for(int i = 0; i < population.size(); i++){
                                    dataset.addValue(population.get(i),series1,populationYears.get(i));
                                }

                                String chartTitle = "Population growth for Punjab";
                                String categoryAxisLabel = "Punjab";
                                String valueAxisLabel = "Population";

                                JFreeChart chart = ChartFactory.createLineChart(chartTitle, categoryAxisLabel, valueAxisLabel, dataset);

                                ChartPanel newChart = new ChartPanel(chart);


                                JLabel punjabStatsTitle = new JLabel("<html>Major census data<BR>");
                                punjabStatsTitle.setFont(titleFont);
                                JTextArea punjabStatsArea = new JTextArea(25,50);

                                //test run data

                                Punjab punjabTemp;
                                try {
                                    FileInputStream fis = new FileInputStream(punjabFile);
                                    ObjectInputStream ois = new ObjectInputStream(fis);
                                    try{
                                        while(fis.available()!= 0){
                                            punjabTemp = (Punjab) ois.readObject();
                                            String var = punjabTemp.toString();
                                            punjabStatsArea.append(var);
                                        }

                                    } catch (ClassNotFoundException ex) {
                                        ex.printStackTrace();
                                    }

                                } catch (IOException ex ) {
                                    ex.printStackTrace();
                                }

                                JScrollPane punjabScrollPane = new JScrollPane(punjabStatsArea);
                                punjabScrollPane.setSize(700,150);
                                punjabStatsArea.add(punjabStatsTitle);
                                punjabStatsFrame.add(punjabScrollPane);
                                punjabStatsFrame.add(punjabBackToMain);
                                punjabStatsFrame.setVisible(true);
                                punjabGraph.add(newChart);
                                punjabGraph.setVisible(true);
                                punjabStatsFrame.setVisible(true);
                            }
                        });

                        //balochistan old data
                        viewBalochB.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                //baloch view census data testing 1 - clear

                                JFrame balochStatsFrame = new JFrame("Previous Data");
                                balochStatsFrame.setSize(500,550);
                                balochStatsFrame.setLayout(new FlowLayout());
                                balochStatsFrame.setResizable(false);
                                balochStatsFrame.setLocationRelativeTo(null);
                                balochStatsFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

                                JFrame balochistanGraph = new JFrame("Balochistan Graph");
                                balochistanGraph.setTitle("Balochistan");
                                balochistanGraph.setAlwaysOnTop(true);
                                balochistanGraph.pack();
                                balochistanGraph.setSize(600, 400);
                                balochistanGraph.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

                                JButton balochBackToMain = new JButton("Back to the main menu.");
                                balochBackToMain.setFont(font);

                                balochBackToMain.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                        mainMenu.setVisible(true);
                                        balochistanGraph.dispose();
                                        balochStatsFrame.dispose();
                                        viewProvinceFrame.dispose();
                                        viewFrame.dispose();
                                    }
                                });

                                DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                                String series1 = "Population";
                                ArrayList<Integer> populationYears = Balochistan1998.getPopulationYears();
                                ArrayList<Integer> population = Balochistan1998.getPopulation();
                                for(int i = 0; i < population.size(); i++){
                                    dataset.addValue(population.get(i),series1,populationYears.get(i));
                                }

                                String chartTitle = "Population growth for Balochistan";
                                String categoryAxisLabel = "Balochistan";
                                String valueAxisLabel = "Population";

                                JFreeChart chart = ChartFactory.createLineChart(chartTitle, categoryAxisLabel, valueAxisLabel, dataset);

                                ChartPanel newChart = new ChartPanel(chart);

                                JLabel balochStatsTitle = new JLabel("<html>Major census data<BR>");
                                balochStatsTitle.setFont(titleFont);
                                JTextArea balochStatsArea = new JTextArea(25,50);

                                //test run data

                                Balochistan balochistanTemp;
                                try {
                                    FileInputStream fis = new FileInputStream(balochFile);
                                    ObjectInputStream ois = new ObjectInputStream(fis);
                                    try{
                                        while(fis.available()!= 0){
                                            balochistanTemp = (Balochistan) ois.readObject();
                                            String var = balochistanTemp.toString();
                                            balochStatsArea.append(var);
                                        }

                                    } catch (ClassNotFoundException ex) {
                                        ex.printStackTrace();
                                    }

                                } catch (IOException ex ) {
                                    ex.printStackTrace();
                                }

                                JScrollPane balochScrollPane = new JScrollPane(balochStatsArea);
                                balochScrollPane.setSize(700,150);
                                balochStatsArea.add(balochStatsTitle);
                                balochStatsFrame.add(balochScrollPane);
                                balochStatsFrame.add(balochBackToMain);
                                balochStatsFrame.setVisible(true);
                                balochistanGraph.add(newChart);
                                balochistanGraph.setVisible(true);
                                balochStatsFrame.setVisible(true);
                            }
                        });

                        //kpk old data
                        viewKPKB.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                //kpk view census data testing 1 - clear

                                JFrame kpkStatsFrame = new JFrame("Previous Data");
                                kpkStatsFrame.setSize(500,550);
                                kpkStatsFrame.setLayout(new FlowLayout());
                                kpkStatsFrame.setResizable(false);
                                kpkStatsFrame.setLocationRelativeTo(null);
                                kpkStatsFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

                                JFrame kpkGraph = new JFrame("Khyber Pakhtunkhwa Graph");
                                kpkGraph.setTitle("KPK");
                                kpkGraph.setAlwaysOnTop(true);
                                kpkGraph.pack();
                                kpkGraph.setSize(600, 400);
                                kpkGraph.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


                                JButton kpkBackToMain = new JButton("Back to the main menu.");
                                kpkBackToMain.setFont(font);

                                kpkBackToMain.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                        mainMenu.setVisible(true);
                                        kpkGraph.dispose();
                                        kpkStatsFrame.dispose();
                                        viewProvinceFrame.dispose();
                                        viewFrame.dispose();
                                    }
                                });


                                DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                                String series1 = "Population";
                                ArrayList<Integer> populationYears = KPK1998.getPopulationYears();
                                ArrayList<Integer> population = KPK1998.getPopulation();
                                for(int i = 0; i < population.size(); i++){
                                    dataset.addValue(population.get(i),series1,populationYears.get(i));
                                }

                                String chartTitle = "Population growth for KPK";
                                String categoryAxisLabel = "KPK";
                                String valueAxisLabel = "Population";

                                JFreeChart chart = ChartFactory.createLineChart(chartTitle, categoryAxisLabel, valueAxisLabel, dataset);

                                ChartPanel newChart = new ChartPanel(chart);

                                JLabel kpkStatsTitle = new JLabel("<html>Major census data<BR>");
                                kpkStatsTitle.setFont(titleFont);
                                JTextArea kpkStatsArea = new JTextArea(25,50);

                                //test run data

                                KPK kpkTemp;
                                try {
                                    FileInputStream fis = new FileInputStream(kpkFile);
                                    ObjectInputStream ois = new ObjectInputStream(fis);
                                    try {
                                        while (fis.available() != 0) {
                                            kpkTemp = (KPK) ois.readObject();
                                            String var = kpkTemp.toString();
                                            kpkStatsArea.append(var);
                                        }

                                    } catch (ClassNotFoundException ex) {
                                        ex.printStackTrace();
                                    }

                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }

                                JScrollPane kpkScrollPane = new JScrollPane(kpkStatsArea);
                                kpkScrollPane.setSize(700, 150);
                                kpkStatsArea.add(kpkStatsTitle);
                                kpkStatsFrame.add(kpkScrollPane);
                                kpkStatsFrame.add(kpkBackToMain);
                                kpkStatsFrame.setVisible(true);
                                kpkGraph.add(newChart);
                                kpkGraph.setVisible(true);
                                kpkStatsFrame.setVisible(true);
                            }
                        });

                        //ict old data
                        viewICTB.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                //ict view census data testing 1 - clear

                                JFrame ictStatsFrame = new JFrame("Previous Data");
                                ictStatsFrame.setSize(500,550);
                                ictStatsFrame.setLayout(new FlowLayout());
                                ictStatsFrame.setResizable(false);
                                ictStatsFrame.setLocationRelativeTo(null);
                                ictStatsFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

                                JFrame ictGraph = new JFrame("ICT Graph");
                                ictGraph.setTitle("ICT");
                                ictGraph.setAlwaysOnTop(true);
                                ictGraph.pack();
                                ictGraph.setSize(600, 400);
                                ictGraph.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

                                JButton ictBackToMain = new JButton("Back to the main menu.");
                                ictBackToMain.setFont(font);

                                ictBackToMain.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                        mainMenu.setVisible(true);
                                        ictGraph.dispose();
                                        ictStatsFrame.dispose();
                                        viewProvinceFrame.dispose();
                                        viewFrame.dispose();
                                    }
                                });

                                DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                                String series1 = "Population";
                                ArrayList<Integer> populationYears = ICT1998.getPopulationYears();
                                ArrayList<Integer> population = ICT1998.getPopulation();
                                for(int i = 0; i < population.size(); i++){
                                    dataset.addValue(population.get(i),series1,populationYears.get(i));
                                }

                                String chartTitle = "Population growth for ICT";
                                String categoryAxisLabel = "ICT";
                                String valueAxisLabel = "Population";

                                JFreeChart chart = ChartFactory.createLineChart(chartTitle, categoryAxisLabel, valueAxisLabel, dataset);

                                ChartPanel newChart = new ChartPanel(chart);

                                JLabel ictStatsTitle = new JLabel("<html>Major census data<BR>");
                                ictStatsTitle.setFont(titleFont);
                                JTextArea ictStatsArea = new JTextArea(25,50);

                                //test run data

                                ICT ictTemp;
                                try {
                                    FileInputStream fis = new FileInputStream(ictFile);
                                    ObjectInputStream ois = new ObjectInputStream(fis);
                                    try {
                                        while (fis.available() != 0) {
                                            ictTemp = (ICT) ois.readObject();
                                            String var = ictTemp.toString();
                                            ictStatsArea.append(var);
                                        }

                                    } catch (ClassNotFoundException ex) {
                                        ex.printStackTrace();
                                    }

                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }

                                JScrollPane ictScrollPane = new JScrollPane(ictStatsArea);
                                ictScrollPane.setSize(700, 150);
                                ictStatsArea.add(ictStatsTitle);
                                ictStatsFrame.add(ictScrollPane);
                                ictStatsFrame.add(ictBackToMain);
                                ictStatsFrame.setVisible(true);
                                ictGraph.add(newChart);
                                ictGraph.setVisible(true);
                                ictStatsFrame.setVisible(true);
                            }
                        });

                        viewProvinceFrame.setVisible(true);
                    }
                });
                viewFrame.setVisible(true);
            }
        });
        mainMenu.setVisible(true);
    }
}

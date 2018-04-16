package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import model.Bibliotheque;
import model.Livre;

public class SaisieDocument extends JFrame {

    private Fenetre main = null;
    public SaisieDocument(Fenetre frame){
        build();
        this.main = frame;
    }
    public void build(){
        setTitle("Saisie d'un document");
        setMinimumSize(new Dimension(800, 600));
        setPreferredSize(new Dimension(800, 600));
        setContentPane(buildContentPane());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(false);
    }
    
    Container buildContentPane()
    {	
            getContentPane().setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();

            /**
             * Positionnement du itre de la page "Saisie d'un document".
             */
            gbc.gridx = 0;
            gbc.gridy = 0; // on commence à la position (0,0)
            gbc.anchor = GridBagConstraints.NORTH; // on commence au début de la ligne
            gbc.gridheight = 1; // le titre ne s'étend que sur une ligne
            gbc.weighty = 1;
            gbc.fill = GridBagConstraints.NONE;
            gbc.gridwidth = GridBagConstraints.REMAINDER; // le titre est le dernier élément de la ligne
            gbc.insets = new Insets(30, 0, 0, 0); 
            
            JLabel titre = new JLabel("Ajouter un document à la bibliothèque");
            titre.setHorizontalAlignment(JLabel.CENTER);
            titre.setFont(new Font("TimesRoman", Font.PLAIN , 28));          
            getContentPane().add(titre, gbc);
            
            /**
            * Positionnement du choix du type de document à ajouter
            */
            String[] typeList = {"Livre", "Roman", "Revue", "Manuel" };
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            gbc.weightx = 0.;
            gbc.weighty = 1.;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.anchor = GridBagConstraints.BASELINE_LEADING; 
            gbc.insets = new Insets(10, 50, 0, 0);
            
            JComboBox type = new JComboBox(typeList);
            type.setFont(new Font("TimesRoman", Font.PLAIN , 24));
            getContentPane().add(type, gbc);
            
            /**
            * Positionnement du label du champ de saisie "Titre du document".
            */
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            gbc.weightx = 0.;
            gbc.weighty = 1.;
            gbc.fill = GridBagConstraints.NONE;
            gbc.anchor = GridBagConstraints.BASELINE_LEADING; 
            gbc.insets = new Insets(10, 50, 0, 0);
            
            JLabel labelTitre = new JLabel("Titre : ");
            labelTitre.setHorizontalAlignment(JLabel.CENTER);
            labelTitre.setFont(new Font("TimesRoman", Font.PLAIN , 24));          
            getContentPane().add(labelTitre, gbc);
            
            /**
            * Positionnement du champ de saisie "Titre du document".
            */
            gbc.gridx = 1; 
            gbc.gridy = 2;
            gbc.gridwidth = GridBagConstraints.REMAINDER; 
            gbc.gridheight = 1; 
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.anchor = GridBagConstraints.BASELINE;
            gbc.insets = new Insets(0, 0, 0, 30);
                        
            final JTextField textTitre = new JTextField();
            textTitre.setFont(new Font("TimesRoman", Font.PLAIN, 24)); 
            getContentPane().add(textTitre, gbc);
            
            /**
            * Positionnement du label du champ de saisie "Nom de l'auteur".
            */
            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            gbc.weightx = 0.;
            gbc.weighty = 1.;
            gbc.fill = GridBagConstraints.NONE;
            gbc.anchor = GridBagConstraints.BASELINE_LEADING; 
            gbc.insets = new Insets(0, 50, 0, 0);
            JLabel labelAuteur = new JLabel("Auteur : ");
            labelAuteur.setFont(new Font("TimesRoman", Font.PLAIN , 24));          
            getContentPane().add(labelAuteur, gbc);
                        
            /**
            * Positionnement du champ de saisie "Nom de l'auteur".
            */
            gbc.gridx = 1; 
            gbc.gridy = 3;
            gbc.gridwidth = GridBagConstraints.REMAINDER; 
            gbc.gridheight = 1; 
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.anchor = GridBagConstraints.BASELINE;
            gbc.insets = new Insets(0, 0, 0, 30);
            
            final JTextField textAuteur = new JTextField();
            textAuteur.setFont(new Font("TimesRoman", Font.PLAIN, 24)); 
            getContentPane().add(textAuteur, gbc);
            
            /**
            *   Positionnement du champ de saisie "Nombre de pages".
            */
            gbc.gridx = 0;
            gbc.gridy = 4;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            gbc.weightx = 0.;
            gbc.weighty = 1.;
            gbc.fill = GridBagConstraints.NONE;
            gbc.anchor = GridBagConstraints.BASELINE_LEADING; 
            gbc.insets = new Insets(0, 40, 0, 0);
            
            JLabel labelPages = new JLabel("Nb pages : ");
            labelPages.setFont(new Font("TimesRoman", Font.PLAIN , 24));          
            getContentPane().add(labelPages, gbc);
            
            /**
            * Positionnement du champ de saisie "Nombre de pages".
            */
            gbc.gridx = 1; 
            gbc.gridy = 4;
            gbc.gridwidth = GridBagConstraints.REMAINDER; 
            gbc.gridheight = 1; 
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.anchor = GridBagConstraints.BASELINE;
            gbc.insets = new Insets(0, 0, 0, 30);
            
            final JTextField textPages = new JTextField();
            textPages.setFont(new Font("TimesRoman", Font.PLAIN, 24)); 
            getContentPane().add(textPages, gbc);
            
            /**
            *   Positionnement du label prix littéraires.
            */
            gbc.gridx = 0;
            gbc.gridy = 5;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            gbc.weightx = 0.;
            gbc.weighty = 0.;
            
            gbc.insets = new Insets(0, 50, 10, 10);
            
            JLabel labelPrix = new JLabel("Prix litteraire : ");
            labelPrix.setFont(new Font("TimesRoman", Font.PLAIN , 24));          
            getContentPane().add(labelPrix, gbc);
            
            /**
            *   Positionnement du choix : "Prix GONCOURT".
            */
            gbc.gridx = 1; 
            gbc.gridy = 5;
            gbc.fill = GridBagConstraints.NONE;
            gbc.anchor = GridBagConstraints.BASELINE;
            gbc.gridheight = 1; 
            gbc.insets = new Insets(0, 50, 10, 10);
            
            final JRadioButton bGoncourt = new JRadioButton("Goncourt");
            bGoncourt.setFont(new Font("TimesRoman", Font.PLAIN , 24));       
            getContentPane().add(bGoncourt, gbc);
             
            /**
            *   Positionnement du choix : "Prix MEDICIS".
            */         
            gbc.gridx = 2; 
            gbc.gridy = 5;
            gbc.anchor = GridBagConstraints.BASELINE;
            gbc.gridheight = 1; 
            gbc.insets = new Insets(0, 50, 10, 10);
            final JRadioButton bMedicis = new JRadioButton("Medicis");
            bMedicis.setFont(new Font("TimesRoman", Font.PLAIN , 24));       
            getContentPane().add(bMedicis, gbc);
            
            /**
            *   Positionnement du choix : "Prix AUTRES".
            */            
            gbc.gridx = 3; 
            gbc.gridy = 5;
            gbc.gridwidth = GridBagConstraints.REMAINDER; 
            gbc.gridheight = 1; 
            gbc.insets = new Insets(0, 50, 10, 10);
            final JRadioButton bAutres = new JRadioButton("Autres");
            bAutres.setFont(new Font("TimesRoman", Font.PLAIN , 24));       
            getContentPane().add(bAutres, gbc);
            
            /**
            *   Positionnement du bouton "Valider".
            */
            gbc.gridx = 0;
            gbc.gridy = 6;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            gbc.weightx = 0.;
            gbc.weighty = 1.;
            gbc.fill = GridBagConstraints.NONE;
            gbc.anchor = GridBagConstraints.BASELINE_LEADING; 
            gbc.insets = new Insets(0, 15, 0, 0);
            
            JButton valider = new JButton("Valider");
            valider.setFont(new Font("TimesRoman", Font.BOLD , 24));
            getContentPane().add(valider);
            
            /**
            *   Positionnement du bouton "Retour au MENU".
            */
            gbc.gridx = 1; 
            gbc.gridy = 6;
            gbc.gridwidth = GridBagConstraints.REMAINDER; 
            gbc.gridheight = 1; 
            //gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.anchor = GridBagConstraints.BASELINE;
            gbc.insets = new Insets(0, 15, 0, 10);
            
            JButton gotomenu = new JButton("Retour au Menu");
            gotomenu.setFont(new Font("TimesRoman", Font.ITALIC , 24));
            gotomenu.setBackground(Color.RED);
            gotomenu.setForeground(Color.WHITE);
            getContentPane().add(gotomenu, gbc);
            
            /**
            * Positionnement des credits.
            */ 
           gbc.gridx = 0;
           gbc.gridy = 7;
           gbc.anchor = GridBagConstraints.LINE_START;
           gbc.insets = new Insets(10, 0, 0, 20);
           gbc.gridwidth = GridBagConstraints.REMAINDER;
           gbc.fill = GridBagConstraints.BOTH;
           
           JLabel credits = new JLabel("Credits : Kilian Poulin & Edouard Ok - (2018)");
           credits.setHorizontalAlignment(JLabel.CENTER);
           credits.setFont(new Font("TimesRoman", Font.PLAIN , 20));
           getContentPane().add(credits, gbc);
        
        valider.addActionListener(new ActionListener()
        {
                @Override
                public void actionPerformed(ActionEvent e)
                { 
                    if(!textTitre.getText().equals("") 
                            && !textAuteur.getText().equals("") 
                            && !textPages.getText().equals("")) {
                        Livre livre = new Livre(textTitre.getText(), textAuteur.getText(), 
                                Integer.parseInt(textPages.getText()));
                        main.biblio.addDocument(livre);
                        setVisible(false);
                        main.frame_afficher.setVisible(true);
                    }
                            
                    
                }
        }
        );
           
        gotomenu.addActionListener(new ActionListener()
        {
                @Override
                public void actionPerformed(ActionEvent e)
                { 
                    SwingUtilities.invokeLater(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            setVisible(false);
                            main.setVisible(true);
                        }            
                    });
                }
        }
        );
        
        
        return getContentPane();
    }	
    
}

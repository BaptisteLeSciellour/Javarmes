package com.example.javarmes.Model.DAO;

import com.example.javarmes.Model.Utilisateurs.Client;

import java.sql.SQLException;
public interface ClientDAO {

    void  Ajouter(Client Client) throws SQLException;
    void MettreAJour(Client Client) throws SQLException;
    void Supprimer(int id) throws SQLException;

    //public List<ClientDAO> ListerClients () throws SQLException;
   // public ClientDAO ChoisirClient (int id) throws SQLException;
/**
 public List<Jouet> rechercherJouet(String recherche) throws SQLException {
 List<Jouet> jouets = new ArrayList<>();
 Connection con = null;
 PreparedStatement pstmnt = null;
 ResultSet resultat = null;
 try {
 con = DAOFactory.getConnection();
 String requete = "SELECT * FROM jouet WHERE nom LIKE ?";
 pstmnt = con.prepareStatement(requete);
 pstmnt.setString(1, "%" + recherche + "%");
 resultat = pstmnt.executeQuery();
 while (resultat.next()) {
 int id = resultat.getInt("id");
 String nom = resultat.getString("nom");
 double prix = resultat.getDouble("prix");
 jouets.add(new Jouet(id, nom, prix));
 }
 } catch (SQLException e) {
 e.printStackTrace();
 } finally {
 if (pstmnt != null) {
 pstmnt.close();
 }
 if (con != null) {
 con.close();
 }
 if (resultat != null) {
 resultat.close();
 }
 }
 return jouets;
 }**/
}

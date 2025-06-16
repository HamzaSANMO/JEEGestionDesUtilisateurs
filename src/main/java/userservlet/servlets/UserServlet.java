package userservlet.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import user.model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//creation de la servlet UserServlet qui hérite de HttpServlet 
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   //constructeur de notre servlet
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	//les deux methodes doGet et doPost de la servlet
    //doGet pour lire le contenu d'une page depuis la servlet
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// on recupere la demande de l'utulisateur puis on lui retourne l'affichage du formulaire
		this.getServletContext().getRequestDispatcher("/WEB-INF/userForm.jsp").forward(request, response);
	}

	//doPost pour ecrire ou envoyer du contenu depuis une page
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Recuperation des donnee d'un utilisateur
		String nom = request.getParameter("nom");
		String email = request.getParameter("email");
		
		//condition pour verifier si les donnees ne pas vides
		if(nom == null || nom.trim().isEmpty() || email == null ||email.trim().isEmpty()) {
			response.getWriter().println("Tous less champs sont obligatoires");
			return;
		}
		
		//creation d'un nouvel objet User
		
		User nouvelUtilisateur = new User(nom, email);
		
		//creation d'une session
		HttpSession session = request.getSession();
		
		//creer une liste des utilisateurs
		List<User> utilisateurs = (List<User>)session.getAttribute("utilisateurs");
		if(utilisateurs == null) {
			utilisateurs = new ArrayList<>();
		}
		
		//ajout d'un nouvel utilisateurs
		utilisateurs.add(nouvelUtilisateur);
		
		//mettre à jour une session
		session.setAttribute("utilisateurs", utilisateurs);
		session.setAttribute("dernierUtilisateur", nouvelUtilisateur);
		
		//redirection vers la JSP
		response.sendRedirect("userDetails.jsp");
	}

}

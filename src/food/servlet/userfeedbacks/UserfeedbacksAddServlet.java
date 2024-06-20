package food.servlet.userfeedbacks;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import food.dao.UserfeedbacksDao;
import food.model.Userfeedbacks;


@WebServlet("/insertuserfeedbacks")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)
public class UserfeedbacksAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserfeedbacksDao UserfeedbacksDao;

	public void init() {
		UserfeedbacksDao = new UserfeedbacksDao();
	}
	public static final String UPLOAD_DIR = "images"+File.separator+"catering";
	public static final String UPLOAD_DIR2="images/catering";
	public String dbFileName = "";
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		String customername = request.getParameter("customername");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");
		
	    Part part = request.getPart("file");

	 /*   String fileName = extractFileName(part);//file name
	    System.out.print("fileName: "+fileName);
	    String applicationPath = getServletContext().getRealPath("");
        String uploadPath = applicationPath  +File.separator+ UPLOAD_DIR;
        System.out.println("applicationPath:" + applicationPath);
        File fileUploadDirectory = new File(uploadPath);
        if (!fileUploadDirectory.exists()) {
            fileUploadDirectory.mkdirs();
        }
	    
//	   String savepath ="D:\\Users\\PC\\eclipse-workspace\\Test2\\WebContent\\PhotographyImg"+File.separator+fileName;
//        String savePath=uploadPath+File.separator+fileName;
        String name1=randomString()+fileName;
        String savePath=uploadPath+File.separator+name1;
	   File filesavedir = new File(savePath);
	   System.out.println("savePath: " + savePath);
       
	   String sRootPath = new File(savePath).getAbsolutePath();
       System.out.println("sRootPath: " + sRootPath);
       part.write(savePath);
       File fileSaveDir1 = new File(savePath);*/
       /*if you may have more than one files with same name then you can calculate some random characters
        and append that characters in fileName so that it will  make your each image name identical.*/
      /* dbFileName = UPLOAD_DIR2 + File.separator + name1;
	   
	   
	   
//	   part.write(savePath+File.separator);
	   
	   String imagePath="/Test2/"+UPLOAD_DIR2+"/"+name1;
//	       /images/rooms/img.pngsssss
	   String imgname=name1;*/
	    Userfeedbacks userfeedbacks = new Userfeedbacks (customername, email, subject,message);
		try {
			UserfeedbacksDao.insertFeedback (userfeedbacks);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("listuserfeedbacks");
	}

	private String extractFileName(Part part) {//This method will print the file name.
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
	
	private String randomString() {
		// create a string of all characters
	    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    // create random string builder
	    StringBuilder sb = new StringBuilder();
	    // create an object of Random class
	    Random random = new Random();
	    // specify length of random string
	    int length = 7;
	    for(int i = 0; i < length; i++) {
	      // generate random index number
	      int index = random.nextInt(alphabet.length());
	      // get character specified by index
	      // from the string
	      char randomChar = alphabet.charAt(index);
	      // append the character to string builder
	      sb.append(randomChar);
	    }
	    String randomString = sb.toString();
		return randomString;
		
	}
}
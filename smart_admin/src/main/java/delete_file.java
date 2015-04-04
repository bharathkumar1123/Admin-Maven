
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/delete_file"})
public class delete_file extends HttpServlet
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
           
                String fname;
                int c=0;
            String a = request.getParameter("file");
            String b = request.getParameter("name");
           String dbURI = "mongodb://Bharath:Bharath@ds033097.mongolab.com:33097/smart";
            MongoClient mongoClient = new MongoClient(new MongoClientURI(dbURI));
            DB db = mongoClient.getDB("smart");
            DBCollection coll = db.getCollection("register");
            DBObject doc = coll.findOne(new BasicDBObject("Name", b));
            GridFS gfsPhoto = new GridFS(db, "files");
            if(doc!=null)
                    {
                        BasicDBList list=(BasicDBList)doc.get("files");
                        for(Object obj : list)
                        {
                            fname=((BasicDBObject)obj).getString("filename");
                            if(fname.equals(a))
                            {
                            GridFSDBFile imageForOutput = gfsPhoto.findOne(fname);
                            DBObject pull = new BasicDBObject("$pull", new BasicDBObject("files",imageForOutput));
                            coll.update(doc,pull);
                            out.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
"	<head>\n" +
"		<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />\n" +
"		<title>LOGS</title>\n" +
"       \n" +
"        <!-- CSS Reset -->\n" +
"		<link rel=\"stylesheet\" type=\"text/css\" href=\"reset.css\" tppabs=\"http://www.xooom.pl/work/magicadmin/css/reset.css\" media=\"screen\" />\n" +
"       \n" +
"        <!-- Fluid 960 Grid System - CSS framework -->\n" +
"		<link rel=\"stylesheet\" type=\"text/css\" href=\"grid.css\" tppabs=\"http://www.xooom.pl/work/magicadmin/css/grid.css\" media=\"screen\" />\n" +
"		\n" +
"        <!-- IE Hacks for the Fluid 960 Grid System -->\n" +
"        <!--[if IE 6]><link rel=\"stylesheet\" type=\"text/css\" href=\"ie6.css\" tppabs=\"http://www.xooom.pl/work/magicadmin/css/ie6.css\" media=\"screen\" /><![endif]-->\n" +
"		<!--[if IE 7]><link rel=\"stylesheet\" type=\"text/css\" href=\"ie.css\" tppabs=\"http://www.xooom.pl/work/magicadmin/css/ie.css\" media=\"screen\" /><![endif]-->\n" +
"        \n" +
"        <!-- Main stylesheet -->\n" +
"        <link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\" tppabs=\"http://www.xooom.pl/work/magicadmin/css/styles.css\" media=\"screen\" />\n" +
"        \n" +
"        <!-- WYSIWYG editor stylesheet -->\n" +
"        <link rel=\"stylesheet\" type=\"text/css\" href=\"jquery.wysiwyg.css\" tppabs=\"http://www.xooom.pl/work/magicadmin/css/jquery.wysiwyg.css\" media=\"screen\" />\n" +
"        \n" +
"        <!-- Table sorter stylesheet -->\n" +
"        <link rel=\"stylesheet\" type=\"text/css\" href=\"tablesorter.css\" tppabs=\"http://www.xooom.pl/work/magicadmin/css/tablesorter.css\" media=\"screen\" />\n" +
"        \n" +
"        <!-- Thickbox stylesheet -->\n" +
"        <link rel=\"stylesheet\" type=\"text/css\" href=\"thickbox.css\" tppabs=\"http://www.xooom.pl/work/magicadmin/css/thickbox.css\" media=\"screen\" />\n" +
"        \n" +
"        <!-- Themes. Below are several color themes. Uncomment the line of your choice to switch to different color. All styles commented out means blue theme. -->\n" +
"        <link rel=\"stylesheet\" type=\"text/css\" href=\"theme-blue.css\" tppabs=\"http://www.xooom.pl/work/magicadmin/css/theme-blue.css\" media=\"screen\" />\n" +
"        <!--<link rel=\"stylesheet\" type=\"text/css\" href=\"css/theme-red.css\" media=\"screen\" />-->\n" +
"        <!--<link rel=\"stylesheet\" type=\"text/css\" href=\"css/theme-yellow.css\" media=\"screen\" />-->\n" +
"        <!--<link rel=\"stylesheet\" type=\"text/css\" href=\"css/theme-green.css\" media=\"screen\" />-->\n" +
"        <!--<link rel=\"stylesheet\" type=\"text/css\" href=\"css/theme-graphite.css\" media=\"screen\" />-->\n" +
"        \n" +
"		<!-- JQuery engine script-->\n" +
"		<script type=\"text/javascript\" src=\"jquery-1.3.2.min.js\" tppabs=\"http://www.xooom.pl/work/magicadmin/js/jquery-1.3.2.min.js\"></script>\n" +
"        \n" +
"		<!-- JQuery WYSIWYG plugin script -->\n" +
"		<script type=\"text/javascript\" src=\"jquery.wysiwyg.js\" tppabs=\"http://www.xooom.pl/work/magicadmin/js/jquery.wysiwyg.js\"></script>\n" +
"        \n" +
"        <!-- JQuery tablesorter plugin script-->\n" +
"		<script type=\"text/javascript\" src=\"jquery.tablesorter.min.js\" tppabs=\"http://www.xooom.pl/work/magicadmin/js/jquery.tablesorter.min.js\"></script>\n" +
"        \n" +
"		<!-- JQuery pager plugin script for tablesorter tables -->\n" +
"		<script type=\"text/javascript\" src=\"jquery.tablesorter.pager.js\" tppabs=\"http://www.xooom.pl/work/magicadmin/js/jquery.tablesorter.pager.js\"></script>\n" +
"        \n" +
"		<!-- JQuery password strength plugin script -->\n" +
"		<script type=\"text/javascript\" src=\"jquery.pstrength-min.1.2.js\" tppabs=\"http://www.xooom.pl/work/magicadmin/js/jquery.pstrength-min.1.2.js\"></script>\n" +
"        \n" +
"		<!-- JQuery thickbox plugin script -->\n" +
"		<script type=\"text/javascript\" src=\"thickbox.js\" tppabs=\"http://www.xooom.pl/work/magicadmin/js/thickbox.js\"></script>\n" +
"        \n" +
"        <!-- Initiate WYIWYG text area -->\n" +
"		<script type=\"text/javascript\">\n" +
"			$(function()\n" +
"			{\n" +
"			$('#wysiwyg').wysiwyg(\n" +
"			{\n" +
"			controls : {\n" +
"			separator01 : { visible : true },\n" +
"			separator03 : { visible : true },\n" +
"			separator04 : { visible : true },\n" +
"			separator00 : { visible : true },\n" +
"			separator07 : { visible : false },\n" +
"			separator02 : { visible : false },\n" +
"			separator08 : { visible : false },\n" +
"			insertOrderedList : { visible : true },\n" +
"			insertUnorderedList : { visible : true },\n" +
"			undo: { visible : true },\n" +
"			redo: { visible : true },\n" +
"			justifyLeft: { visible : true },\n" +
"			justifyCenter: { visible : true },\n" +
"			justifyRight: { visible : true },\n" +
"			justifyFull: { visible : true },\n" +
"			subscript: { visible : true },\n" +
"			superscript: { visible : true },\n" +
"			underline: { visible : true },\n" +
"            increaseFontSize : { visible : false },\n" +
"            decreaseFontSize : { visible : false }\n" +
"			}\n" +
"			} );\n" +
"			});\n" +
"        </script>\n" +
"        \n" +
"        <!-- Initiate tablesorter script -->\n" +
"        <script type=\"text/javascript\">\n" +
"			$(document).ready(function() { \n" +
"				$(\"#myTable\") \n" +
"				.tablesorter({\n" +
"					// zebra coloring\n" +
"					widgets: ['zebra'],\n" +
"					// pass the headers argument and assing a object \n" +
"					headers: { \n" +
"						// assign the sixth column (we start counting zero) \n" +
"						6: { \n" +
"							// disable it by setting the property sorter to false \n" +
"							sorter: false \n" +
"						} \n" +
"					}\n" +
"				}) \n" +
"			.tablesorterPager({container: $(\"#pager\")}); \n" +
"		}); \n" +
"		</script>\n" +
"        \n" +
"        <!-- Initiate password strength script -->\n" +
"		<script type=\"text/javascript\">\n" +
"			$(function() {\n" +
"			$('.password').pstrength();\n" +
"			});\n" +
"        </script>\n" +
"		<script>\n" +
"document.getElementById('my_selection').onchange = function() {\n" +
"    window.location.href = this.children[this.selectedIndex].getAttribute('href');\n" +
"}\n" +
"</script>\n" +
"	</head>\n" +
"	<body>\n" +
"\n" +
"    	<!-- Header -->\n" +
"        <div id=\"header\">\n" +
"            <!-- Header. Status part -->\n" +
"            <div id=\"header-status\">\n" +
"                <div class=\"container_12\">\n" +
"                    <div class=\"grid_8\">\n" +
"					&nbsp;\n" +
"					<ul>\n" +
"								<li><img style=\"PADDING-LEFT: 150px\" src=\"log.png\" alt=\"\"></li>\n" +
"								<li><img  src=\"logo.png\" alt=\"\"></li>\n" +
"					</ul>\n" +
"					 <ul id=\"nav\">\n" +
"                                <li><a href=\"admin.jsp\">Dashboard</a></li>\n" +
"                               <li><a href=\"add.jsp\">Add User</a></li>\n" +
"                                <li><a href=\"delete.jsp\">Delete Data and User</a></li>\n" +
"                                 <li id=\"current\"><a href=\"log.jsp\">Log Activities </a></li>\n" +
"                                <li><a href=\"form.jsp\">Notification</a></li>\n" +
"                            </ul>\n" +
"                    </div>\n" +
"                    <div class=\"grid_4\">\n" +
"			\n" +
"                        <a href=\"logout.jsp\" id=\"logout\">\n" +
"                         );\n" +
"                    HttpSession session = request.getSession(false);\n" +
"\n" +
"                                                                     \n");
                    HttpSession session = request.getSession(false);

                                                                     
		if(session!=null){
		a=(String)session.getAttribute("username");
		out.print(a+"&nbsp; &nbsp;Logout");
		}
		else{
			out.print("Please login first");
			request.getRequestDispatcher("login.jsp").include(request, response);
       		}     out.println("</a>\n" +
"                     </a>\n" +
"                    </div>\n" +
"                </div>\n" +
"				\n" +
"                <div style=\"clear:both;\"></div>\n" +
"            </div> <!-- End #header-status -->\n" +
"            \n" +
"            <!-- Header. Main part -->\n" +
"           \n" +
"                    <div style=\"clear: both;\"></div>\n" +
"                </div><!-- End. .container_12 -->\n" +
"            </div> <!-- End #header-main -->\n" +
"            <div style=\"clear: both;\"></div>\n" +
"            <!-- Sub navigation -->\n" +
"<center>File is DELETED</center> </div>\n" +
"                \n" +
"           \n" +
"        <!-- Footer -->\n" +
"        <div id=\"footer\">\n" +
"        	<div class=\"container_12\">\n" +
"            	<div class=\"grid_12\">\n" +
"                	<!-- You can change the copyright line for your own -->\n" +
"                	<p>&copy; 2015. Smart Minds</p>\n" +
"        		</div>\n" +
"            </div>\n" +
"            <div style=\"clear:both;\"></div>\n" +
"        </div> <!-- End #footer -->\n" +
"	</body>\n" +
"</html>\n" +
"");
                            c=1;
                            }
                           
                        }
                         if(c==0)
                                out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n" +
"<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
"	<head>\n" +
"		<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />\n" +
"		<title>LOGS</title>\n" +
"       \n" +
"        <!-- CSS Reset -->\n" +
"		<link rel=\"stylesheet\" type=\"text/css\" href=\"reset.css\" tppabs=\"http://www.xooom.pl/work/magicadmin/css/reset.css\" media=\"screen\" />\n" +
"       \n" +
"        <!-- Fluid 960 Grid System - CSS framework -->\n" +
"		<link rel=\"stylesheet\" type=\"text/css\" href=\"grid.css\" tppabs=\"http://www.xooom.pl/work/magicadmin/css/grid.css\" media=\"screen\" />\n" +
"		\n" +
"        <!-- IE Hacks for the Fluid 960 Grid System -->\n" +
"        <!--[if IE 6]><link rel=\"stylesheet\" type=\"text/css\" href=\"ie6.css\" tppabs=\"http://www.xooom.pl/work/magicadmin/css/ie6.css\" media=\"screen\" /><![endif]-->\n" +
"		<!--[if IE 7]><link rel=\"stylesheet\" type=\"text/css\" href=\"ie.css\" tppabs=\"http://www.xooom.pl/work/magicadmin/css/ie.css\" media=\"screen\" /><![endif]-->\n" +
"        \n" +
"        <!-- Main stylesheet -->\n" +
"        <link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\" tppabs=\"http://www.xooom.pl/work/magicadmin/css/styles.css\" media=\"screen\" />\n" +
"        \n" +
"        <!-- WYSIWYG editor stylesheet -->\n" +
"        <link rel=\"stylesheet\" type=\"text/css\" href=\"jquery.wysiwyg.css\" tppabs=\"http://www.xooom.pl/work/magicadmin/css/jquery.wysiwyg.css\" media=\"screen\" />\n" +
"        \n" +
"        <!-- Table sorter stylesheet -->\n" +
"        <link rel=\"stylesheet\" type=\"text/css\" href=\"tablesorter.css\" tppabs=\"http://www.xooom.pl/work/magicadmin/css/tablesorter.css\" media=\"screen\" />\n" +
"        \n" +
"        <!-- Thickbox stylesheet -->\n" +
"        <link rel=\"stylesheet\" type=\"text/css\" href=\"thickbox.css\" tppabs=\"http://www.xooom.pl/work/magicadmin/css/thickbox.css\" media=\"screen\" />\n" +
"        \n" +
"        <!-- Themes. Below are several color themes. Uncomment the line of your choice to switch to different color. All styles commented out means blue theme. -->\n" +
"        <link rel=\"stylesheet\" type=\"text/css\" href=\"theme-blue.css\" tppabs=\"http://www.xooom.pl/work/magicadmin/css/theme-blue.css\" media=\"screen\" />\n" +
"        <!--<link rel=\"stylesheet\" type=\"text/css\" href=\"css/theme-red.css\" media=\"screen\" />-->\n" +
"        <!--<link rel=\"stylesheet\" type=\"text/css\" href=\"css/theme-yellow.css\" media=\"screen\" />-->\n" +
"        <!--<link rel=\"stylesheet\" type=\"text/css\" href=\"css/theme-green.css\" media=\"screen\" />-->\n" +
"        <!--<link rel=\"stylesheet\" type=\"text/css\" href=\"css/theme-graphite.css\" media=\"screen\" />-->\n" +
"        \n" +
"		<!-- JQuery engine script-->\n" +
"		<script type=\"text/javascript\" src=\"jquery-1.3.2.min.js\" tppabs=\"http://www.xooom.pl/work/magicadmin/js/jquery-1.3.2.min.js\"></script>\n" +
"        \n" +
"		<!-- JQuery WYSIWYG plugin script -->\n" +
"		<script type=\"text/javascript\" src=\"jquery.wysiwyg.js\" tppabs=\"http://www.xooom.pl/work/magicadmin/js/jquery.wysiwyg.js\"></script>\n" +
"        \n" +
"        <!-- JQuery tablesorter plugin script-->\n" +
"		<script type=\"text/javascript\" src=\"jquery.tablesorter.min.js\" tppabs=\"http://www.xooom.pl/work/magicadmin/js/jquery.tablesorter.min.js\"></script>\n" +
"        \n" +
"		<!-- JQuery pager plugin script for tablesorter tables -->\n" +
"		<script type=\"text/javascript\" src=\"jquery.tablesorter.pager.js\" tppabs=\"http://www.xooom.pl/work/magicadmin/js/jquery.tablesorter.pager.js\"></script>\n" +
"        \n" +
"		<!-- JQuery password strength plugin script -->\n" +
"		<script type=\"text/javascript\" src=\"jquery.pstrength-min.1.2.js\" tppabs=\"http://www.xooom.pl/work/magicadmin/js/jquery.pstrength-min.1.2.js\"></script>\n" +
"        \n" +
"		<!-- JQuery thickbox plugin script -->\n" +
"		<script type=\"text/javascript\" src=\"thickbox.js\" tppabs=\"http://www.xooom.pl/work/magicadmin/js/thickbox.js\"></script>\n" +
"        \n" +
"        <!-- Initiate WYIWYG text area -->\n" +
"		<script type=\"text/javascript\">\n" +
"			$(function()\n" +
"			{\n" +
"			$('#wysiwyg').wysiwyg(\n" +
"			{\n" +
"			controls : {\n" +
"			separator01 : { visible : true },\n" +
"			separator03 : { visible : true },\n" +
"			separator04 : { visible : true },\n" +
"			separator00 : { visible : true },\n" +
"			separator07 : { visible : false },\n" +
"			separator02 : { visible : false },\n" +
"			separator08 : { visible : false },\n" +
"			insertOrderedList : { visible : true },\n" +
"			insertUnorderedList : { visible : true },\n" +
"			undo: { visible : true },\n" +
"			redo: { visible : true },\n" +
"			justifyLeft: { visible : true },\n" +
"			justifyCenter: { visible : true },\n" +
"			justifyRight: { visible : true },\n" +
"			justifyFull: { visible : true },\n" +
"			subscript: { visible : true },\n" +
"			superscript: { visible : true },\n" +
"			underline: { visible : true },\n" +
"            increaseFontSize : { visible : false },\n" +
"            decreaseFontSize : { visible : false }\n" +
"			}\n" +
"			} );\n" +
"			});\n" +
"        </script>\n" +
"        \n" +
"        <!-- Initiate tablesorter script -->\n" +
"        <script type=\"text/javascript\">\n" +
"			$(document).ready(function() { \n" +
"				$(\"#myTable\") \n" +
"				.tablesorter({\n" +
"					// zebra coloring\n" +
"					widgets: ['zebra'],\n" +
"					// pass the headers argument and assing a object \n" +
"					headers: { \n" +
"						// assign the sixth column (we start counting zero) \n" +
"						6: { \n" +
"							// disable it by setting the property sorter to false \n" +
"							sorter: false \n" +
"						} \n" +
"					}\n" +
"				}) \n" +
"			.tablesorterPager({container: $(\"#pager\")}); \n" +
"		}); \n" +
"		</script>\n" +
"        \n" +
"        <!-- Initiate password strength script -->\n" +
"		<script type=\"text/javascript\">\n" +
"			$(function() {\n" +
"			$('.password').pstrength();\n" +
"			});\n" +
"        </script>\n" +
"		<script>\n" +
"document.getElementById('my_selection').onchange = function() {\n" +
"    window.location.href = this.children[this.selectedIndex].getAttribute('href');\n" +
"}\n" +
"</script>\n" +
"	</head>\n" +
"	<body>\n" +
"\n" +
"    	<!-- Header -->\n" +
"        <div id=\"header\">\n" +
"            <!-- Header. Status part -->\n" +
"            <div id=\"header-status\">\n" +
"                <div class=\"container_12\">\n" +
"                    <div class=\"grid_8\">\n" +
"					&nbsp;\n" +
"					<ul>\n" +
"								<li><img style=\"PADDING-LEFT: 150px\" src=\"log.png\" alt=\"\"></li>\n" +
"								<li><img  src=\"logo.png\" alt=\"\"></li>\n" +
"					</ul>\n" +
"					 <ul id=\"nav\">\n" +
"                                <li><a href=\"admin.jsp\">Dashboard</a></li>\n" +
"                               <li><a href=\"add.jsp\">Add User</a></li>\n" +
"                                <li><a href=\"delete.jsp\">Delete Data and User</a></li>\n" +
"                                 <li id=\"current\"><a href=\"log.jsp\">Log Activities </a></li>\n" +
"                                <li><a href=\"form.jsp\">Notification</a></li>\n" +
"                            </ul>\n" +
"                    </div>\n" +
"                    <div class=\"grid_4\">\n" +
"			\n" +
"                        <a href=\"logout.jsp\" id=\"logout\">\n");
                    HttpSession session = request.getSession(false);

                                                                     
		if(session!=null){
		a=(String)session.getAttribute("username");
		out.print(a+"&nbsp; &nbsp;Logout");
		}
		else{
			out.print("Please login first");
			request.getRequestDispatcher("login.jsp").include(request, response);
       		}     out.println("</a>\n" +
"                    </div>\n" +
"                </div>\n" +
"				\n" +
"                <div style=\"clear:both;\"></div>\n" +
"            </div> <!-- End #header-status -->\n" +
"            \n" +
"            <!-- Header. Main part -->\n" +
"           \n" +
"                    <div style=\"clear: both;\"></div>\n" +
"                </div><!-- End. .container_12 -->\n" +
"            </div> <!-- End #header-main -->\n" +
"            <div style=\"clear: both;\"></div>\n" +
"            <!-- Sub navigation -->\n" +
"          <center> <br/><br/>Files does not exists in your collection..</center> </div>\n" +
"                \n" +
"           \n" +
"        <!-- Footer -->\n" +
"        <div id=\"footer\">\n" +
"        	<div class=\"container_12\">\n" +
"            	<div class=\"grid_12\">\n" +
"                	<!-- You can change the copyright line for your own -->\n" +
"                	<p>&copy; 2015. Smart Minds</p>\n" +
"        		</div>\n" +
"            </div>\n" +
"            <div style=\"clear:both;\"></div>\n" +
"        </div> <!-- End #footer -->\n" +
"	</body>\n" +
"</html>\n" +
"");
                    }
    }
}

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}



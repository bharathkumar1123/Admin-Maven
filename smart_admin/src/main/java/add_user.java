/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.Random;
/**
 *
 * @author bharath
 */
@WebServlet(urlPatterns = {"/add_user"})
public class add_user extends HttpServlet {

    /**
     * Processes requests for both HTTP <codeGET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Registeration</title>");
            out.println("</head>");
            out.println("<body>");
          
            
            response.sendRedirect("admin.jsp");
            out.println("</body>");
            out.println("</html>");
            String a,b,c,d,e,f,g,s;
            a=request.getParameter("name");
            b=request.getParameter("prof");
            c=request.getParameter("org");
            d=request.getParameter("user");
            e=request.getParameter("mob");
            f=request.getParameter("email");
            g=request.getParameter("password");
          
       

//Get the session object
  Properties props = new Properties();
  props.put("mail.smtp.host", "smtp.gmail.com");
  props.put("mail.smtp.socketFactory.port", "465");
  props.put("mail.smtp.socketFactory.class",
        	"javax.net.ssl.SSLSocketFactory");
  props.put("mail.smtp.auth", "true");
  props.put("mail.smtp.port", "465");

  Session session = Session.getInstance(props,
   new javax.mail.Authenticator() {
   @Override
   protected PasswordAuthentication getPasswordAuthentication() {
   return new PasswordAuthentication("smartstorechallenge@gmail.com","smarttcs");//change accordingly
   }
  });

//compose message
  try {
   MimeMessage message = new MimeMessage(session);
   message.setFrom(new InternetAddress("smartstorechallenge@gmail.com"));//change accordingly
   message.addRecipient(Message.RecipientType.TO,new InternetAddress(f));
   message.setSubject("Smart Store Registeration");
  /* message.setText("username");
   message.setText(f);
   message.setText("Password");
   message.setText(g);*/
   message.setText("You have been Successfully Registered\n"+"Username:"+f+"\n"+"Password:"+g+"\n");

   //send message
   Transport.send(message);

   out.println("message sent successfully");

  } 
  catch (MessagingException j)
  {
  out.println("Error");
  }
  int n,i=0,j=0,k=0,l,m,p=1,j1=0,p1=1,len2=0,len1,len,rem,rem1,quot,quot1,j2,p2,count,jj,pp,lt,jj1,jj2,jj3,pp1,pp2,pp3;
		String s1="",e1="0", o="1",k1="",k2="",k3="",k4="",x1="",x2="",x3="",x4="",code="",total,tot="";
		String str="",c1,b1,c2, key="",c3, t1="",t2="",t3="",t4="",c4="",c5,c6,remaining="";
                
		String res[]=new String[1000];
		String res1[]=new String[1000];
		String binar[]=new String[1000];
		String dna[]=new String[1000];
		String dna1[]=new String[1000];
		String dna2[]=new String[1000];
		String dna3[]=new String[1000];
		String res2[]=new String[1000];
                             
		char ch,ch1;
                add_user h=new add_user();
                str=g;
                l=str.length();
		for (int cc=0; cc<l-1; cc++)
               	 	{
                    		ch = str.charAt(cc);
	                    	if (!Character.isUpperCase(ch))
               	     		{
                       			 str=str.toUpperCase();
                   	 	}	 
          	  	} 
		//s=str.replace('T','U');
		System.out.println("pattern"+str);
		System.out.println("pattern length"+l);
                // DNA code generation
		for(i=0;i<=l-1;i++)
		{
			//System.out.println("i value"+i);
			//System.out.println("j value"+j);
			//System.out.println("p value"+p);
			if(k!=-1)
			{
				res[i]=str.substring(j,p);
				System.out.println(res[i]);
			}
			j=j+1;
			p=p+1;
		}
                // binary code generation
		
		c1=h.dna(res); 
		System.out.println(c1);
		int l1=c1.length();
		c1=c1.replace('U','T');
		System.out.println(c1);
		for(int i1=0;i1<=l1-1;i1++)
		{
			if(k!=-1)
			{
				res1[i1]=c1.substring(j1,p1);
				//System.out.println("result"+res1[i1]);
			}
			j1=j1+1;
			p1=p1+1;
		}
		c2=h.code(res1);
		System.out.println(c2);
//parity bit generation
		len=c2.length();
		quot=len/4;
		rem = (len)% (4);
		j2=0;
		p2=quot;
		count=0;
		System.out.println("Length of binary seq"+len+"REM"+rem);
		if (rem ==0)
		{
			for(int gg=0;gg<4;gg++)
			{
				binar[gg]=c2.substring(j2,p2);
				System.out.println("j2"+" "+j2);
				System.out.println("p2"+" "+p2);
				System.out.println("no parity"+" "+c2);
				System.out.println("no parity array"+" "+binar[gg]);
				j2=p2;
				p2=p2+quot;
			}
		}
		else
		{
			for (int sh=0; sh<len-1; sh++)
               	 		{
                    			ch = c2.charAt(sh);
	                    		if (ch == '1')
               	     			{
                       			 	count=count+1;
                   	 		}	 
			} 				
			int cn = (count) %(2);
			if(cn==0)
			{
				for(int v=0;v<rem;v++)
				{
					c2=c2+e1;	
					//System.out.println("value"+v);
					System.out.println("even"+" "+c2);
				}
				len1=c2.length();
				len2=len1/4;
				System.out.println("len1"+len1);
				rem1=(len1)%(4);
				quot1=len1/4;
				//System.out.println("quot"+quot1);
				p2=quot1;
				//System.out.println("p2"+p2);
				for(int g1=0;g1<4;g1++)
				{
					//System.out.println("c2"+c2);
					binar[g1]=c2.substring(j2,p2);
					//System.out.println("j2"+j2);
					//System.out.println("p2"+p2);
					System.out.println("even parity array"+" "+binar[g1]);
					j2=p2;
					p2=p2+quot1;
				}
				//System.out.println("j2"+j2);
				//System.out.println("p2"+p2);
			}
			else
			{
				for(int w=0;w<rem;w++)
				{
					c2=c2+o;
					System.out.println("odd"+" "+c2);
				}
				for(int g2=0;g2<len-1;g2++)
				{
					binar[g2]=c2.substring(j2,p2);
					System.out.println("odd parity array"+"  "+binar[g2]);
				}
			}
			 
		}
                k1=binar[0];
		k2=binar[1];
		k3=binar[2];
		k4=binar[3];
                String bits = ""; 
                int binlen=k1.length();
		Random r = new Random(); 
		for(int r1=0; r1<binlen; r1++)
		{ 
			int x = 0; 
			if(r.nextBoolean()) {
                        x=1;
                    } 
			bits += x; 
		} 
		System.out.println("binlen"+binlen); 
		key=bits;
		System.out.println("key"+" "+key);
                System.out.println("keylength"+key.length());

		System.out.println("k1"+k1);
		String temp1[]=k1.split("");
		String temp2[]=k2.split("");
		String temp3[]=k3.split("");
		String temp4[]=k4.split("");
		String temp5[]=key.split("");
System.out.print("temp1");
		for(int sas=0;sas<=key.length()-1;sas++)
		{
                       System.out.println("array"+sas);
			System.out.print(temp1[sas]);
                     
		}
		/*System.out.print("temp2");
		for(int sas1=0;sas1<=key.length()-1;sas1++)
		{
			System.out.print(temp2[sas1]);
		}
		System.out.print("temp3");
		for(int sas2=0;sas2<=key.length()-1;sas2++)
		{
			System.out.print(temp3[sas2]);
		}
		System.out.print("temp4");
		for(int sas3=0;sas3<=key.length()-1;sas3++)
		{
			System.out.print(temp4[sas3]);
		}
		System.out.print("temp5");
		for(int sas4=0;sas4<=key.length()-1;sas4++)
		{
			System.out.print(temp5[sas4]);
		}*/
		
		for(int gg=0;gg<=key.length()-1;gg++)
		{
			System.out.println("gg"+gg);
			System.out.println("key length"+key.length());
			if((temp1[gg]).equals((temp5[gg])))
			{
				temp1[gg]="0";
                                System.out.print("tempaa"+temp1[gg]);
			}
			else
			{
				temp1[gg]="1";
                                System.out.print("tempaa"+temp1[gg]);
			}
		}
		for(int g1=0;g1<=key.length()-1;g1++)
		{
			//System.out.println("temp2"+temp2[g1]);
			//System.out.println("temp5b4"+temp5[g1]);
			if((temp2[g1]).equals((temp5[g1])))
			{
				temp2[g1]="0";
				System.out.print("tempaa"+temp2[g1]);
			}
			else
			{
				temp2[g1]="1";
				System.out.print("temp2xx"+temp2[g1]);
			}
		}
		for(int g2=0;g2<=key.length()-1;g2++)
		{
			if((temp3[g2]).equals((temp5[g2])))
			{
				temp3[g2]="0";
			}
			else
			{
				temp3[g2]="1";
			}
		}
		for(int g3=0;g3<=key.length()-1;g3++)
		{
			if((temp4[g3]).equals((temp5[g3])))
			{
				temp4[g3]="0";
			}
			else
			{
				temp4[g3]="1";
			}
		}
		System.out.println();
		System.out.print("After xor temp1");
		/*for(int sa=0;sa<=key.length()-1;sa++)
		{
			System.out.print(" "+temp1[sa]);
		}
		System.out.println();
		System.out.print("After xor temp2");
		/*for(int sa1=0;sa1<=key.length()-1;sa1++)
		{
			System.out.print(" "+temp2[sa1]);
		}*/
		/*System.out.println();
		System.out.print("After xor temp3");
		for(int sa2=0;sa2<=key.length()-1;sa2++)
		{
			System.out.print(" "+temp3[sa2]);
		}
		System.out.println();
		System.out.print(" After xor temp4");
		for(int sa3=0;sa3<=key.length()-1;sa3++)
		{
			System.out.print(" "+temp4[sa3]);
		}
		System.out.println();*/
//rule 51
		for(int ba=0;ba<=key.length()-1;ba++)
		{
			//System.out.print("AFTER"+temp1[ba]);
			if((temp1[ba]).equals("0"))
			{
				temp1[ba]="1";
                                
			}
			else
			{
				temp1[ba]="0";
			}
			//System.out.print("RULE"+temp1[ba]);
		}
		for(int ba1=0;ba1<=key.length()-1;ba1++)
		{
			if((temp2[ba1]).equals("0"))
			{
				temp2[ba1]="1";
			}
			else
			{
				temp2[ba1]="0";
			}
			//System.out.print("RULE"+temp2[ba1]);
		}
		for(int ba2=0;ba2<=key.length()-1;ba2++)
		{
			if((temp3[ba2]).equals("0"))
			{
				temp3[ba2]="1";
			}
			else
			{
				temp3[ba2]="0";
			}
			//System.out.print("RULE"+temp3[ba2]);
		}
		for(int ba3=0;ba3<=key.length()-1;ba3++)
		{
			if((temp4[ba3]).equals("0"))
			{
				temp4[ba3]="1";
			}
			else
			{
				temp4[ba3]="0";
			}
			//System.out.print("RULE"+temp4[ba3]);
		}
		

//AFTer rule 51
		for(int kk=0;kk<=key.length()-1;kk++)
		{
			t1=t1+temp1[kk];
		}
		System.out.println("t1"+" "+t1);
		for(int kk1=0;kk1<=key.length()-1;kk1++)
		{
			t2=t2+temp2[kk1];
		}
		System.out.println("t2"+" "+t2);
		for(int kk2=0;kk2<=key.length()-1;kk2++)
		{
			t3=t3+temp3[kk2];
		}
		System.out.println("t3"+" "+t3);
		for(int kk3=0;kk3<=key.length()-1;kk3++)
		{
			t4=t4+temp4[kk3];
		}
		System.out.println("t4"+" "+t4);
		total=t1+t2+t3+t4;
		lt=total.length();
		//System.out.println("Length"+lt);
		 jj=0;
		pp=2;
		for(int gg=0;gg<lt/2;gg++)
		{
			dna[gg]=total.substring(jj,pp);
			//System.out.println("jj"+jj);
			//System.out.println("pp"+pp);
			//System.out.println(" split of binary array1"+dna[gg]);
			jj=pp;
			pp=pp+2;
		}
		c3=h.bin(dna);
		System.out.println("c3"+" "+c3);
		int leng=c3.length();
		//System.out.println("Length of C3"+leng);
		//code=code+c3+c4+c4+c5;
		//System.out.println("code"+total);
		for(int kk1=1;kk1<=total.length();kk1++)
		{
			tot=tot+dna[kk1];
		}

		 jj1=0;
		pp1=3;
		int cl=c3.length();
		c4=c3.replace("T","U");
		//System.out.println("t to u"+c4);
		int q1=cl/3;
		int r1=cl%3;
		if( r1 == 0)
		{
			for(int gg1=0;gg1<cl/3;gg1++)
			{
				dna1[gg1]=c4.substring(jj1,pp1);
				//System.out.println("jj1"+jj1);
				//System.out.println("pp1"+pp1);
				//System.out.println(" split of dna array"+dna1[gg1]);
				jj1=pp1;
				pp1=pp1+3;
				
			}
		}
		else
		{
			for(int gg3=0;gg3<cl/3;gg3++)
			{
				dna1[gg3]=c4.substring(jj1,pp1);
				//System.out.println("jj1"+jj1);
				//System.out.println("pp1"+pp1);
				//System.out.println(" split of dna array"+dna1[gg3]);
				jj1=pp1;
				pp1=pp1+3;
				
			}
			for(int gg2=0;gg2<r1;gg2++)
			{
				int lll=cl-1;
				remaining=c4.substring(lll);
				System.out.println("c1-1"+lll);
				if(r1>1)
				{
					lll=lll-1;
					//System.out.println("greater remainder"+lll);
				}
				//System.out.println("remaining"+remaining);
			}
		}
		
		
		c5=h.dnacode(dna1);
		System.out.println("c4"+c4);
		c5=c5+remaining;
		System.out.println("Encrypted Data"+" "+c5);
		int c5len=c5.length();
		System.out.println("Length of  encrypted data"+" "+c5len);
        
		


	
             String dbURI = "mongodb://Bharath:Bharath@ds033097.mongolab.com:33097/smart";
            MongoClient mongoClient = new MongoClient(new MongoClientURI(dbURI));
            DB db = mongoClient.getDB("smart");
            DBCollection coll = db.getCollection("register");
            DBObject doc = new BasicDBObject().append("Name",a).append("Profession",b).append("Organisation",c).append("User_type",d).append("Mobile_no",e).append("email_id",f).append("Password",c5).append("Key",key);
            coll.insert(doc);
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
    public String dna(String[] text) 
	 {
		int i1,j1=0,p1=1,k=0;
		String dup="";
		HashMap<String,String> hm = new HashMap<>();
		hm.put("A", "UUU");
	      	hm.put("B", "UUC");
     		hm.put("C", "UUA");
	      	hm.put("D", "UUG");
	    	hm.put("E", "CUU");
		hm.put("F", "CUC");
		hm.put("G", "CUA");
	      	hm.put("H", "CUG");
     		hm.put("I", "AUU");
	      	hm.put("J", "AUC");
	    	hm.put("K", "AUA");
		hm.put("L", "AUG");
		hm.put("M", "GUU");
	      	hm.put("N", "GUC");
     		hm.put("O", "GUA");
	      	hm.put("P", "GUG");
	    	hm.put("Q", "UCU");
		hm.put("R", "UCC");
		hm.put("S", "UCA");
      		hm.put("T", "UCG");
		hm.put("U", "CCU");
		hm.put("V", "CCC");
	    	hm.put("W", "CCA");
		hm.put("X", "CCG");
		hm.put("Y", "ACU");
		hm.put("Z", "ACC");
		hm.put("1", "ACA");
      		hm.put("2", "ACG");
	      	hm.put("3", "GCU");
	       	hm.put("4", "GCC");
      		hm.put("5", "GCA");
	      	hm.put("6", "GCG");
     		hm.put("7", "UAU");
	      	hm.put("8", "UAC");
                hm.put("9", "UAA");
		hm.put("0", "UAG");
		hm.put("/", "AGC");
	      	hm.put("*", "AAG");
	     	hm.put("-", "GGG");
	      	hm.put("+", "UUT");
	  	hm.put("!", "CAU");
		hm.put("@", "CAC");
		hm.put("#", "CAA");
	      	hm.put("$", "CAG");
     		hm.put("%", "AAU");
	      	hm.put("^", "AAC");
	 	hm.put("&", "AAA");
		hm.put("(", "GAU");
		hm.put(")", "GAC");
		hm.put("_", "GGA");
		hm.put("=", "CCT");
		hm.put(":", "CGA");
		hm.put(";", "CGG");
		hm.put("'", "CGC");
		hm.put( " ", "CGU");
		hm.put(",", "GGC");
		hm.put("<", "GGU");
		hm.put(">", "AGA");
		hm.put("?", "AGU");
		//hm.put("", new String("AGG"));
		hm.put(",", "GGC");
		hm.put("[", "UGU");
		hm.put("]", "UGC");
		hm.put("{", "GAA");
		hm.put("}", "GAG");
		//hm.put(" \", new String("UGA"));
		hm.put("_", "GGA");
		hm.put("|", "UGG");
	 	  String words[] = text;
	    	 for( String word : words)
		{
	    	 	String sent = hm.get(word);
	    		 if( sent != null) 
	    	 	{
				
	    		  	dup=dup+sent;
			
				//System.out.println(dup);
	    	 	}
	     
		}
	return dup;
	}

//BINARY CODE GENERATION FUNCTION

 public  String code(String[] text) 
	 {
		String dup1="";
		HashMap<String,String> bm = new HashMap<String,String>();
		bm.put("A", "00");
		bm.put("G", "01");
		//bm.put("U", new String("10"));
		bm.put("T", "10");
		bm.put("C", "11");
		String words1[] = text;
		for( String word : words1)
		{
	    		 String sent = bm.get(word);
	    		 if( sent != null) 
	    	 	{
	    		 	 dup1=dup1+sent;
				//System.out.println(dup1);
	    	 	}
	     	}
		return dup1;
}
// binary to DNA code word
public String bin(String[] text)
{
	String dup2="";
	HashMap<String, String> dm = new HashMap<String, String>();
	dm.put("00", "A");
	dm.put("01", "G");
	dm.put("10", "T");
	dm.put("11", "C");
	String words2[] = text;
	for( String word : words2)
	{
		 String sent = dm.get(word);
	    	if( sent != null) 
	    	{
	    	 	 dup2=dup2+sent;
			//System.out.println(dup2);
	    	}
	}
	return dup2;
}
 public  String dnacode(String[] text) 
	 {
		int i1,j1=0,p1=1,k=0;
		String dup="";
		HashMap<String,String> hm = new HashMap<String,String>();
		hm.put("UUU", "F1");
	      	hm.put("UUC", "F2");
     		hm.put("UUA", "L1");
	      	hm.put("UUG", "L2");
	    	hm.put("CUU", "L3");
		hm.put("CUC", "L4");
		hm.put("CUA", "L5");
	      	hm.put("CUG", "L6");
     		hm.put("AUU", "I1");
	      	hm.put("AUC", "I2");
	    	hm.put("AUA", "I3");
		hm.put("AUG", "M1");
		hm.put("GUU", "V1");
	      	hm.put("GUC", "V2");
     		hm.put("GUA", "V3");
	      	hm.put("GUG", "V4");
	    	hm.put("UCU", "S1");
		hm.put("UCC", "S2");
		hm.put("UCA", "S3");
      		hm.put("UCG", "S4");
		hm.put("CCU", "P1");
		hm.put("CCC", "P2");
	    	hm.put("CCA", "P3");
		hm.put("CCG", "P4");
		hm.put("ACU", "T1");
		hm.put("ACC", "T2");
		hm.put("ACA", "T3");
      		hm.put("ACG", "T4");
	      	hm.put("GCU", "A1");
	       	hm.put("GCC", "A2");
      		hm.put("GCA", "A3");
	      	hm.put("GCG", "A4");
     		hm.put("UAU", "Y1");
	      	hm.put("UAC", "Y2");
	 	hm.put("UAA", "B1");
		hm.put("UAG", "B2");
		hm.put("AGC", "S6");
	      	hm.put("AAG", "K2");
	     	hm.put("GGG", "G4");
	      	hm.put("UUT", "X1");
	  	hm.put("CAU", "H1");
		hm.put("CAC", "H2");
		hm.put("CAA", "Q1");
	      	hm.put("CAG", "Q2");
     		hm.put("AAU", "N1");
	      	hm.put("AAC", "N2");
	 	hm.put("AAA", "K1");
		hm.put("GAU", "D1");
		hm.put("GAC", "D2");
		hm.put("GGA", "G3");
		hm.put("CCT", "X2");
		hm.put("CGA", "R3");
		hm.put("CGG", "R4");
		hm.put("CGC", "R2");
		hm.put( "CGU ", "R1");
		hm.put("GGC", "G2");
		hm.put("GGU", "G1");
		hm.put("AGA", "R5");
		hm.put("AGU", "S5");
		hm.put("AGG", "R6");
		hm.put("GGC", "G2");
		hm.put("UGU", "C1");
		hm.put("UGC", "C2");
		hm.put("GAA", "E1");
		hm.put("GAG", "E2");
		hm.put("UGA", "W2");
		hm.put("GGA", "G3");
		hm.put("UGG", "W1");
	 	  String words[] = text;
	    	 for( String word : words)
		{
	    	 	String sent = hm.get(word);
	    		 if( sent != null) 
	    	 	{
				
	    		  	dup=dup+sent;
			
				//System.out.println(dup);
	    	 	}
	     
		}
	return dup;
         }


}

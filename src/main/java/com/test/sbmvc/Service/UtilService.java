package com.test.sbmvc.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.test.sbmvc.Model.User;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Random;

@Service
public class UtilService{

    //Generating Random Password
    public char[] geek_Password(int len)
    {
        System.out.println("Generating password using random() : ");

        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*_=+-/.?<>)";

        String values = Capital_chars + Small_chars +
                numbers + symbols;

        Random rndm_method = new Random();

        char[] password = new char[len];

        for (int i = 0; i < len; i++)
        {
            password[i] =
                    values.charAt(rndm_method.nextInt(values.length()));

        }
        System.out.print("Your new password is : "+password);
        return password;
    }

    //Generating Random OTP
    public char[] OTP(int len)
    {
        System.out.println("Generating OTP using random() : ");

        String numbers = "0123456789";
        Random rndm_method = new Random();

        char[] otp = new char[len];

        for (int i = 0; i < len; i++)
        {
            otp[i] =
                    numbers.charAt(rndm_method.nextInt(numbers.length()));
        }

        System.out.print("You OTP is : "+otp);
        return otp;
    }

    public String createJWT(User user){
        String token=null;
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            token = JWT.create()
                    .withIssuer("aroop").withClaim("role","admin")
                    .sign(algorithm);

        } catch (UnsupportedEncodingException exception){
        } catch (JWTCreationException exception){
        }

        //verifyToken(token);
        //decodeToken(token);
        return token;
    }

    public void verifyToken(String token)
    {
        try {
            System.out.println("token: "+token);
            Algorithm algorithm = Algorithm.HMAC256("secret");
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("aroop").withClaim("role","admin")
                    .build(); //Reusable verifier instance
            DecodedJWT jwt = verifier.verify(token);
            String claim = jwt.getClaim("role").asString();
            System.out.println("JWT Claim jwt.getClaim(\"role\")= "+claim);
            if(claim.equals("admin"))
                System.out.println("Valid User");
            else
                System.out.println("InValid User");
        } catch (UnsupportedEncodingException exception){
            exception.printStackTrace();
            //UTF-8 encoding not supported
        } catch (JWTVerificationException exception){
            //Invalid signature/claims
            throw exception;
        }
    }

    public void decodeToken(String token)
    {
        try {
            DecodedJWT jwt = JWT.decode(token);
            System.out.println("JWT Issuer= "+jwt.getClaim("iss").asString());
        } catch (JWTDecodeException exception){
            //Invalid token
        }
    }


    /* //Sending SMS using msg91
    public String hitUrl(String urlToHit, String param)
    {
        try
        {
            URL url = new URL(urlToHit);
            HttpURLConnection http = (HttpURLConnection)url.openConnection();
            http.setDoOutput(true);
            http.setDoInput(true);
            http.setRequestMethod("POST");

            DataOutputStream wr = new DataOutputStream(http.getOutputStream());
            wr.writeBytes(param);
            // use wr.write(param.getBytes("UTF-8")); for unicode message's instead of wr.writeBytes(param);

            wr.flush();
            wr.close();
            http.disconnect();


            BufferedReader in = new BufferedReader(new InputStreamReader(http.getInputStream()));
            String inputLine;
            if ((inputLine = in.readLine()) != null)
            {
                in.close();
                return inputLine;
            }
            else
            {
                in.close();
                return "-1";
            }

        }
        catch(Exception e)
        {
            System.out.println("Exception Caught..!!!");
            e.printStackTrace();
            return "-2";
        }
    }
    public void sendMessage()
    {
        String strUrl = "http://api.msg91.com/api/postsms.php";
        String xmlData = "data="+
                "<MESSAGE>"+
                "<AUTHKEY>213340AsPdQBb4ll5ae93f47</AUTHKEY>"+
                "<ROUTE>default</ROUTE>"+
                "<SMS TEXT='message1 testing' FROM='9910890842'>"+
                "<ADDRESS TO='9910890842'></ADDRESS>"+
                "</SMS>"+
                "</MESSAGE>";

        String output = hitUrl(strUrl, xmlData);
        System.out.println("Output is: "+output);
    }*/

   /* public void sendOzekiSMS()
    {
        try {

            String recipient = "+919910890842";

            String message = " Greetings from Mr. Gupta! Have a nice day!";

            String username = "admin";

            String password = "abc123";

            String originator = "+919910890842";

            String requestUrl  = "http://127.0.0.1:9501/api?action=sendmessage&" +

                    "username=" + URLEncoder.encode(username, "UTF-8") +

                    "&password=" + URLEncoder.encode(password, "UTF-8") +

                    "&recipient=" + URLEncoder.encode(recipient, "UTF-8") +

                    "&messagetype=SMS:TEXT" +

                    "&messagedata=" + URLEncoder.encode(message, "UTF-8") +

                    "&originator=" + URLEncoder.encode(originator, "UTF-8") +

                    "&serviceprovider=GSMModem1" +

                    "&responseformat=html";

            URL url = new URL(requestUrl);

            HttpURLConnection uc = (HttpURLConnection)url.openConnection();

            System.out.println(uc.getResponseMessage());

            uc.disconnect();

        } catch(Exception ex) {

            System.out.println(ex.getMessage());

        }
    }
*/
}

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripper;

import org.junit.Assert;
import org.junit.Test;

public class newMethod {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		pdfMethod();
		
		
	}

	
	public static void pdfMethod() throws IOException {
		String filePath="D:\\TestProject\\Automation-Exercise\\src\\test\\resources\\tests\\Bank-Statement-Template-1-TemplateLab.pdf";
		//URL url = new URL(filePath);
		File file = new File(filePath);
	
			//InputStream iStream = url.openStream();
			//BufferedInputStream bfStream = new BufferedInputStream(iStream);
			PDDocument document = Loader.loadPDF(file);
			PDFTextStripper stripper = new PDFTextStripper();
			String text = stripper.getText(document);
			System.out.println(text);
			Assert.assertTrue(text.contains("John Smith"));
	        //Assert.assertTrue(text.contains("Account Type"));
	        //Assert.assertTrue(text.contains("Location"));
			
		

	}
}

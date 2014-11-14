package prop.seminar1;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import prop.seminar1.node.INode;
import prop.seminar1.parser.IParser;
import prop.seminar1.parser.Parser;

public class Program {
	public static void main(String[] args) {
		String inputFileName = "input.txt";
		String outputFileName = "output.txt";
		IParser parser = null;
		INode root = null; // Root of the parse tree.
		StringBuilder builder = null;
		FileOutputStream stream = null;
		OutputStreamWriter writer = null;
		
		try {
			try {
				//if (args.length < 2)
					//throw new Exception("Incorrect number of parameters to program.");
				//inputFileName = args[0];
				//outputFileName = args[1];
				
				parser = new Parser();
				parser.open(inputFileName);
				root = parser.parse();
				builder = new StringBuilder();
				builder.append("PARSE TREE:\r\n");
				root.translate(builder, 0);
				
				stream = new FileOutputStream(outputFileName);
				writer = new OutputStreamWriter(stream);
				writer.write(builder.toString());
			}
			catch (Exception exception) {
				exception.printStackTrace();
				System.out.println("EXCEPTION: " + exception);
			}
			finally {
				if (parser != null)
					parser.close();
				if (writer != null)
					writer.close();
				if (stream != null)
					stream.close();
			}
		}
		catch (Exception exception) {
			exception.printStackTrace();
			System.out.println("EXCEPTION: " + exception);
		}
	}
}

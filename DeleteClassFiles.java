import java.nio.file.SimpleFileVisitor;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.FileVisitResult;



public class DeleteClassFiles extends SimpleFileVisitor<Path>{

	public static void main(String[] args){
		try{
			DeleteClassFiles d = new DeleteClassFiles();
			Path current = Paths.get(args[0]);
			Files.walkFileTree(current,d);
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
		catch(ArrayIndexOutOfBoundsException ex){
			throw new ArrayIndexOutOfBoundsException("You forgot the arguments");
		}
	}


	public FileVisitResult visitFile(Path path, BasicFileAttributes attributes) throws IOException{
		if(path.getFileName().toString().endsWith(".class")){
			Files.delete(path);
		}
		return FileVisitResult.CONTINUE;
	}
}
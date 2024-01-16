# deleting the directory
rm -rf target

# creating new dir
mkdir target

# set destination directory for class files
javac -d ./target src/java/edu/school21/printer/*/*.java

# specify where to find user class files
java -classpath target edu.school21.printer.app.Program . 0 /Users/wylisjef/Desktop/it.bmp
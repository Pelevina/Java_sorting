void main() {
    Scanner in = new Scanner(System.in);
    System.out.print("Enter length of the collection: ");
    int lengthCollection = in.nextInt();
    if (lengthCollection > 0) {
        Map<String, Reader> readerMap = new HashMap<>();
        Reader consoleReader = new ConsoleReader();
        Reader randomReader = new RandomReader();
        Reader fileReader = new FileReader();
        readerMap.put(consoleReader.getReaderName(), consoleReader);
        readerMap.put(randomReader.getReaderName(), randomReader);
        readerMap.put(fileReader.getReaderName(), fileReader);
        System.out.print("Enter the way of data input: ");
        String readerName = in.nextLine();
        if (readerMap.containsKey(readerName)) {

        }
        else {
            System.out.println("Wrong way of input");
        }
    }
    else {
        System.out.print("Wrong length of collection");
    }
}

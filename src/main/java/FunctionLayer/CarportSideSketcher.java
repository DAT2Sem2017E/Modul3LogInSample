package FunctionLayer;


public class CarportSideSketcher {

    public String CarportSideSketcher(int length, int heigth) {
        
        return buildSvgString(length, heigth);
    }

    /**
     * builds the side of the carport, and returns a string of all the necessary svg strings
     * @param length
     * @param height
     * @return String - finished svg tags
     */
    private String buildSvgString(int length, int height) {
        StringBuilder sb = new StringBuilder();
        sb.append(buildRoof(length));
        sb.append(buildPost(length, 200));
                
        return sb.toString();
    }

    /**
     * Builds the roof length, and returns svg string
     * @param length
     * @return svg rectangle string for roof
     */
    private String buildRoof(int length) {
     
        
        String roof = "<rect x=\"0cm\" y=\"0cm\" width=\""+ length +"cm\" height=\"10cm\" style=\"fill: blue\" />";
        
        return roof;
    }

    /**
     * calculates where to place posts and returns string
     * @param length
     * @param height
     * @return String - svg tags for posts
     */
    private String buildPost(int length, int height) {
        String post1 = "<rect x=\"0cm\" y=\"-10cm\" width=\"10cm\" height=\"" + height + "cm\" style=\"fill: black\" />";
        String post2 = "<rect x=\""+ (length-10) +"cm\" y=\"-10cm\" width=\"10cm\" height=\"" + height + "cm\" style=\"fill: blue\" />";
        
        return post1 + post2;
    }
}

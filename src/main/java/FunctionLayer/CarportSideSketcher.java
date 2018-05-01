package FunctionLayer;


public class CarportSideSketcher {

    public String CarportSideSketcher(int length, int heigth, int shedWidth, int shedLength) {
        
        return buildSvgString(length, heigth, shedWidth, shedLength);
    }

    /**
     * builds the side of the carport, and returns a string of all the necessary svg strings
     * @param length
     * @param height
     * @return String - finished svg tags
     */
    private String buildSvgString(int length, int height, int shedWidth, int shedLength) {
        StringBuilder sb = new StringBuilder();
        sb.append(buildRoof(length));
        sb.append(buildPost(length, 200));
        if(shedWidth > 0 && shedLength >0) {
            sb.append(buildShed(length, 200, shedLength));
        }
                
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
        String post1 = "<rect x=\"0cm\" y=\"10cm\" width=\"10cm\" height=\"" + height + "cm\" style=\"fill: black\" />";
        String post2 = "<rect x=\""+ (length-10) +"cm\" y=\"10cm\" width=\"10cm\" height=\"" + height + "cm\" style=\"fill: blue\" />";
        
        String postDefs = "<defs>\n" +
            "    <marker id=\"beginArrow\" \n" +
            "    	markerWidth=\"9\" markerHeight=\"9\" \n" +
            "    	refX=\"0\" refY=\"4\" \n" +
            "    	orient=\"auto\">\n" +
            "        <path d=\"M0,4 L8,0 L8,8 L0,4\" style=\"fill: #000000s;\" />\n" +
            "    </marker>\n" +
            "    <marker id=\"endArrow\" \n" +
            "    	markerWidth=\"9\" markerHeight=\"9\" \n" +
            "    	refX=\"8\" refY=\"4\" \n" +
            "    	orient=\"auto\">\n" +
            "        <path d=\"M0,0 L8,4 L0,8 L0,0\" style=\"fill: #000000;\" />\n" +
            "    </marker>\n" +
            "</defs>";
        
        String heightInfo = "<line x1=\""+(length + 10)+"cm\" y1=\"0cm\" x2=\""+(length+10)+"cm\" y2=\""+(height)+"cm\" style=\"stroke:#006600; marker-start: url(#beginArrow); marker-end: url(#endArrow);\"/>";
        
        return post1 + post2 + postDefs + heightInfo;
    }

    private String buildShed(int length, int height, int shedLength) {
        String shed = "<rect x=\""+ (length - shedLength) +"cm\" y=\"10cm\" width=\""+(shedLength-10)+"cm\" height=\"" + height + "cm\" style=\"fill: brown\" />";
        String door = "<rect x=\""+ (length - shedLength) +"cm\" y=\"40cm\" width=\"4cm\" height=\"" + (height-30) + "cm\" style=\"fill: black\" />";
        
        return shed + door;
    }
}

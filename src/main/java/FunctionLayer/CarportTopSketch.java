/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

public class CarportTopSketch
{

    public String CarportTopSketcher(int length, int width, int shedWidth, int shedLength)
    {

        return buildSvgString(length, width, shedWidth, shedLength);
    }

    private String buildSvgString(int length, int width, int shedWidth, int shedLength)
    {
        StringBuilder sb = new StringBuilder();

        sb.append(buildArrowheads());
        sb.append(buildRoof(length, width));
        sb.append(buildRafters(length, width));
        if (shedWidth > 0 && shedLength > 0) {
            sb.append(buildShed(length, width, shedWidth, shedLength));
        }

        return sb.toString();
    }

    private String buildRoof(int length, int width)
    {
        //entire roof area
        String roof = "<rect x=\"0cm\" y=\"0cm\" width=\"" + length + "cm\" height=\"" + width + "cm\" style=\"stroke:black; stroke-width:2cm; fill-opacity:0; \" />";

        //rems 0,7m. in from roof area
        String rem1 = "<rect x=\"0cm\" y=\"70cm\" width=\"" + length + "cm\" height=\"4.5cm\" style=\"stroke:black; stroke-width:2cm; fill-opacity:0; \" />";
        String rem2 = "<rect x=\"0cm\" y=\"" + (width - 70) + "cm\" width=\"" + length + "cm\" height=\"4.5cm\" style=\"stroke:black; stroke-width:2cm; fill-opacity:0; \" />";

        //Height details
        String heightArrow = "<line x1=\""+(length + 35)+"cm\" y1=\"0cm\" x2=\""+(length+35)+"cm\" y2=\""+(width)+"cm\" style=\"stroke:#000000\" stroke-width=\"1.5cm\" marker-start=\"url(#beginArrow)\" marker-end=\"url(#endArrow)\"/>";
        String text = "<text x=\""+ (length+45) +"cm\" y=\""+ (width/2) +"cm\" fill=\"red\" font-size=\"10cm\" >"+width+" cm.</text>\n";
        
        
        //length details
        String lengthArrow = "<line x1=\"0cm\" y1=\""+(width+35)+"cm\" x2=\""+(length)+"cm\" y2=\""+(width+35)+"cm\" style=\"stroke:#000000\" stroke-width=\"1.5cm\" marker-start=\"url(#beginArrow)\" marker-end=\"url(#endArrow)\"/>";
        String text2 = "<text x=\""+ (length/2) +"cm\" y=\""+ (width+45) +"cm\" fill=\"red\" font-size=\"10cm\" >"+width+" cm.</text>\n";
        
        return roof + rem1 + rem2 + heightArrow + text + lengthArrow + text2;
    }

    private String buildRafters(int length, int width)
    {
        String support = "";
        // 0,7m. in from roof area
        for (int i = 0; i < length; i += (length / 14)) {
            support += "<rect x=\"" + i + "cm\" y=\"0cm\" width=\"4.5cm\" height=\"" + width + "cm\" style=\"stroke:black; stroke-width:2cm; fill-opacity:0; \" />";
        }

        return support;
    }

    private String buildShed(int length, int width, int shedwidth, int shedLength)
    {
        String shed = "<rect x=\"" + (length - shedLength) + "cm\" y=\"70cm\" width=\"" + (shedLength) + "cm\" height=\"" + (shedwidth) + "cm\" stroke-dasharray=\"2cm, 2cm\" style=\"stroke:black; stroke-width:2cm; fill-opacity:0; \" />";

        
        //length details
        String lengthArrow = "<line x1=\""+(length-shedLength)+"cm\" y1=\""+(width+10)+"cm\" x2=\""+(length)+"cm\" y2=\""+(width+10)+"cm\" style=\"stroke:#000000\" stroke-width=\"1.5cm\" marker-start=\"url(#beginArrow)\" marker-end=\"url(#endArrow)\"/>";
        String lengthText = "<text x=\""+ ((length/2)+(shedLength/2)) +"cm\" y=\""+ (width+25) +"cm\" fill=\"red\" font-size=\"10cm\" >"+shedLength+" cm.</text>\n";
        
        
        //Height details
        String heightArrow = "<line x1=\""+(length + 10)+"cm\" y1=\"70cm\" x2=\""+(length+10)+"cm\" y2=\""+(shedwidth+70)+"cm\" style=\"stroke:#000000\" stroke-width=\"1.5cm\" marker-start=\"url(#beginArrow)\" marker-end=\"url(#endArrow)\"/>";
        String HeightText = "<text x=\""+ (length+25) +"cm\" y=\""+ ((width/2)+10) +"cm\" fill=\"red\" font-size=\"10cm\" >"+width+" cm.</text>\n";
        
        return shed + lengthArrow + lengthText + heightArrow + HeightText;
    }
    
    
    
    
    private String buildArrowheads() {
        //Code for generating the arrowhead on the line that shows length and height
        return "<defs>\n" +
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
    }
}

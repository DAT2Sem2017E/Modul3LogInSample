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

        sb.append(buildRoof(length, width));
        sb.append(buildSupport(length, width));
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

        return roof + rem1 + rem2;
    }

    private String buildSupport(int length, int width)
    {
        String support = "";
        //rems 0,7m. in from roof area
        for (int i = 0; i < length; i += (length / 14)) {
            support += "<rect x=\"" + i + "cm\" y=\"0cm\" width=\"4.5cm\" height=\"" + width + "cm\" style=\"stroke:black; stroke-width:2cm; fill-opacity:0; \" />";
        }

        return support;
    }

    private String buildShed(int length, int width, int shedwidth, int shedLength)
    {
        String shed = "<rect x=\"" + (length - shedLength) + "cm\" y=\"70cm\" width=\"" + (shedLength) + "cm\" height=\"" + (shedwidth) + "cm\" stroke-dasharray=\"2cm, 2cm\" style=\"stroke:black; stroke-width:2cm; fill-opacity:0; \" />";

        return shed;
    }
}

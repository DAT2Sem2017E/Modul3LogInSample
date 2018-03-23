package FunctionLayer;

import DBAccess.OrderMapper;
import DBAccess.UserMapper;
import java.util.ArrayList;

/**
 * The purpose of LogicFacade is to...
 *
 * @author kasper
 */
public class LogicFacade {

    public static User login(String email, String password) throws LoginSampleException {
        return UserMapper.login(email, password);
    }

    public static User createUser(String email, String password) throws LoginSampleException {
        User user = new User(email, password, "customer");
        UserMapper.createUser(user);
        return user;
    }

    public static ArrayList<OrderEntity> getOrders(int userId) throws OrderException {
        return OrderMapper.getOrders(userId);
    }

    public static ArrayList<OrderEntity> getEmployeeOrders() throws OrderException {
        return OrderMapper.getEmployeeOrders();
    }

    public static OrderEntity getOrder(int orderId) throws OrderException {
        return OrderMapper.getOrder(orderId);
    }

    public static boolean changeStatus(int orderId) throws OrderException {
        return OrderMapper.changeStatus(orderId);
    }

    public static boolean createOrder(int width, int length, int height, int userId) throws OrderException {
        return OrderMapper.createOrder(width, length, height, userId);
    }

    public static ArrayList<Side> getBricks(int width, int length, int height) throws LoginSampleException {
        ArrayList<Brick> brickList = new ArrayList<>();
        ArrayList<Side> sidesList = new ArrayList<>();

        Brick Onex2 = new Brick(1, 2, "1x2");
        Brick Twox2 = new Brick(2, 2, "2x2");
        Brick Twox4 = new Brick(2, 4, "2x4");
        Brick door = new Brick(1, 2, 3, "Door");
        Brick window = new Brick(1, 2, 1, "Window");

        int sidea = length;
        int sideb = width - 4;
        int longest, shortest;

        //figures out which side is longest so i know where to add the door and window
        if (sidea > sideb) {
            longest = sidea;
            shortest = sideb;
        } else {
            longest = sideb;
            shortest = sidea;
        }

        //calculates bricks for sidea and sidec
        //i find out if the entire length can be filled with 2x4's
        int remaining = longest % Twox4.getLength();
        if (remaining == 0) {
            //finds out how manybricks are needed
            int numBricks = longest / Twox4.getLength();
            //if theres need an od number of bricks i fill the side with
            //as many 2x4 as possible -1 and then use 2x2 to fill the rest
            if (numBricks % 2 != 0) {
                //fills sideA
                for (int i = 0; i < numBricks - 1; i++) {
                    brickList.add(Twox4);
                }
                brickList.add(Twox2);
                brickList.add(Twox2);
                brickList.add(door);
                sidesList.add(new Side(brickList, "sideA"));
                brickList = new ArrayList<Brick>();
                //fills sideC
                for (int i = 0; i < numBricks - 1; i++) {
                    brickList.add(Twox4);
                }
                brickList.add(Twox2);
                brickList.add(Twox2);
                brickList.add(window);
                sidesList.add(new Side(brickList, "sideC"));
                brickList = new ArrayList<Brick>();
            } else {
                //if theres needed an even number of bricks i fill half the length with 2x4's
                //and the rest with 2x2's
                //fills sideA
                int numBricks2 = numBricks / 2;
                for (int i = 0; i < numBricks2; i++) {
                    brickList.add(Twox4);
                }
                for (int i = 0; i < (numBricks2 * 2) - 1; i++) {
                    brickList.add(Twox2);
                }
                brickList.add(Twox2);
                brickList.add(door);
                sidesList.add(new Side(brickList, "sideA"));
                brickList = new ArrayList<Brick>();
                //fills sideC
                for (int i = 0; i < numBricks2; i++) {
                    brickList.add(Twox4);
                }
                for (int i = 0; i < (numBricks2 * 2); i++) {
                    brickList.add(Twox2);
                }
                brickList.add(Twox2);
                brickList.add(window);
                sidesList.add(new Side(brickList, "sideC"));
                brickList = new ArrayList<Brick>();
            }

            //if the entire length can't be filled with 2x4's
            //here there is 1 dot left so i fill the side with as many 
            //2x4's as possible and a single 1x2
        } else if (remaining == 1) {
            //fills sideA
            int numBricks = longest / Twox4.getLength();
            for (int i = 0; i < numBricks - 1; i++) {
                brickList.add(Twox4);
            }
            brickList.add(Twox2);
            brickList.add(Twox2);
            brickList.add(Onex2);
            brickList.add(door);
            sidesList.add(new Side(brickList, "sideA"));
            brickList = new ArrayList<Brick>();

            //does it again for sideC
            for (int i = 0; i < numBricks - 1; i++) {
                brickList.add(Twox4);
            }
            brickList.add(Twox2);
            brickList.add(Twox2);
            brickList.add(Onex2);
            brickList.add(window);
            sidesList.add(new Side(brickList, "sideC"));
            brickList = new ArrayList<Brick>();

            //here i fill the side with as many 2x4's as possible and a single 2x2
        } else if (remaining == 2) {
            //fills sideA
            int numBricks = longest / Twox4.getLength();
            for (int i = 0; i < numBricks; i++) {
                brickList.add(Twox4);
            }
            brickList.add(Twox2);
            brickList.add(door);
            sidesList.add(new Side(brickList, "sideA"));
            brickList = new ArrayList<Brick>();
            //fills sideC
            for (int i = 0; i < numBricks; i++) {
                brickList.add(Twox4);
            }
            brickList.add(Twox2);
            brickList.add(window);
            sidesList.add(new Side(brickList, "sideC"));
            brickList = new ArrayList<Brick>();

            //here i fill the side with as many 2x4's as possible, and one 2x2 and 1x2
        } else if (remaining == 3) {
            //fills sideA
            int numBricks = longest / Twox4.getLength();
            for (int i = 0; i < numBricks; i++) {
                brickList.add(Twox4);
            }
            brickList.add(Onex2);
            brickList.add(Twox2);
            brickList.add(door);
            sidesList.add(new Side(brickList, "sideA"));
            brickList = new ArrayList<Brick>();
            //fills sideC
            for (int i = 0; i < numBricks; i++) {
                brickList.add(Twox4);
            }
            brickList.add(Onex2);
            brickList.add(Twox2);
            brickList.add(window);
            sidesList.add(new Side(brickList, "sideC"));
            brickList = new ArrayList<Brick>();
        }

        //calculates bricks for sideb and sided
        remaining = shortest % Twox4.getLength();
        if (remaining == 0) {
            int numBricks = shortest / Twox4.getLength();
            if (numBricks % 2 != 0) {
                //if there's needed 3 or more bricks for this side
                //i fill it with 2x4's and 2x2's
                if (numBricks >= 3) {
                    //fills sideB
                    for (int i = 0; i < numBricks - 1; i++) {
                        brickList.add(Twox4);
                    }
                    brickList.add(Twox2);
                    brickList.add(Twox2);
                    sidesList.add(new Side(brickList, "sideB"));
                    brickList = new ArrayList<Brick>();
                    //fills sideD
                    for (int i = 0; i < numBricks - 1; i++) {
                        brickList.add(Twox4);
                    }
                    brickList.add(Twox2);
                    brickList.add(Twox2);
                    sidesList.add(new Side(brickList, "sideD"));
                    brickList = new ArrayList<Brick>();

                    //if there's needed 2 or less bricks i fill the side with 2x2's and 1x2's
                } else {
                    //fills sideB
                    numBricks = shortest / Twox2.getLength();
                    for (int i = 0; i < numBricks - 1; i++) {
                        brickList.add(Twox2);
                    }
                    brickList.add(Onex2);
                    brickList.add(Onex2);
                    sidesList.add(new Side(brickList, "sideB"));
                    brickList = new ArrayList<Brick>();
                    //fills sideD
                    for (int i = 0; i < numBricks - 1; i++) {
                        brickList.add(Twox2);
                    }
                    brickList.add(Onex2);
                    sidesList.add(new Side(brickList, "sideD"));
                    brickList = new ArrayList<Brick>();
                }

            } else {
                //the same as above. If there's needed 2 or less bricks
                //i fill the side with 2x2's and 1x2's
                if (numBricks <= 2) {
                    //fills sideB
                    numBricks = shortest / Twox2.getLength();
                    for (int i = 0; i < numBricks / 2; i++) {
                        brickList.add(Twox2);
                    }
                    for (int i = 0; i < numBricks; i++) {
                        brickList.add(Onex2);
                    }
                    sidesList.add(new Side(brickList, "sideB"));
                    brickList = new ArrayList<Brick>();
                    //fills sideD
                    for (int i = 0; i < numBricks / 2; i++) {
                        brickList.add(Twox2);
                    }
                    for (int i = 0; i < numBricks; i++) {
                        brickList.add(Onex2);
                    }
                    sidesList.add(new Side(brickList, "sideD"));
                    brickList = new ArrayList<Brick>();
                    //if there's neeeded 3 or more bricks i fill the side with 2x4's and 2x2's
                } else {
                    //fills sideB
                    int numBricks2 = numBricks / 2;
                    for (int i = 0; i < numBricks2; i++) {
                        brickList.add(Twox4);
                    }
                    for (int i = 0; i < numBricks2 * 2; i++) {
                        brickList.add(Twox2);
                    }
                    sidesList.add(new Side(brickList, "sideB"));
                    brickList = new ArrayList<Brick>();
                    //fills sideD
                    for (int i = 0; i < numBricks2; i++) {
                        brickList.add(Twox4);
                    }
                    for (int i = 0; i < numBricks2 * 2; i++) {
                        brickList.add(Twox2);
                    }
                    sidesList.add(new Side(brickList, "sideD"));
                    brickList = new ArrayList<Brick>();
                }

            }
            //if the entire length can't be filled with 2x4's
            //here there is 1 dot left so i fill the side with as many 
            //2x4's as possible and a single 1x2
        } else if (remaining == 1) {
            //fills sideB
            int numBricks = shortest / Twox4.getLength();
            brickList.add(Onex2);
            for (int i = 0; i < numBricks; i++) {
                brickList.add(Twox4);
            }
            sidesList.add(new Side(brickList, "sideB"));
            brickList = new ArrayList<Brick>();

            //fills sideD
            brickList.add(Onex2);
            for (int i = 0; i < numBricks; i++) {
                brickList.add(Twox4);
            }
            sidesList.add(new Side(brickList, "sideD"));
            brickList = new ArrayList<Brick>();

            //here i fill the side with as many 2x4's as possible and a single 2x2
        } else if (remaining == 2) {
            //fills sideB
            int numBricks = shortest / Twox4.getLength();
            brickList.add(Twox2);
            for (int i = 0; i < numBricks; i++) {
                brickList.add(Twox4);
            }
            sidesList.add(new Side(brickList, "sideB"));
            brickList = new ArrayList<Brick>();

            //fills sideD
            brickList.add(Twox2);
            for (int i = 0; i < numBricks; i++) {
                brickList.add(Twox4);
            }
            sidesList.add(new Side(brickList, "sideD"));
            brickList = new ArrayList<Brick>();
            //here i fill the side with as many 2x4's as possible, and one 2x2 and 1x2
        } else if (remaining == 3) {
            //fills sideB
            int numBricks = shortest / Twox4.getLength();
            brickList.add(Onex2);
            brickList.add(Twox2);
            for (int i = 0; i < numBricks; i++) {
                brickList.add(Twox4);
            }
            sidesList.add(new Side(brickList, "sideB"));
            brickList = new ArrayList<Brick>();

            //fills sideD
            brickList.add(Onex2);
            brickList.add(Twox2);
            for (int i = 0; i < numBricks; i++) {
                brickList.add(Twox4);
            }
            sidesList.add(new Side(brickList, "sideD"));
            brickList = new ArrayList<Brick>();
        }

        return sidesList;
    }

}

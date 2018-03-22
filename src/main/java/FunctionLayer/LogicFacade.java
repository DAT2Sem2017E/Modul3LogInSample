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

    public static ArrayList<OrderEntity> getOrders(int userId) throws LoginSampleException {
        return OrderMapper.getOrders(userId);
    }

    public static ArrayList<OrderEntity> getEmployeeOrders() throws LoginSampleException {
        return OrderMapper.getEmployeeOrders();
    }

    public static OrderEntity getOrder(int orderId) throws LoginSampleException {
        return OrderMapper.getOrder(orderId);
    }

    public static boolean changeStatus(int orderId) throws LoginSampleException {
        return OrderMapper.changeStatus(orderId);
    }

    public static boolean createOrder(int width, int length, int height, int userId) throws LoginSampleException {
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

        //calculates bricks for sidea and sidec
        int remaining = sidea % Twox4.getLength();
        if (remaining == 0) {
            int numBricks = sidea / Twox4.getLength();
            if (numBricks % 2 != 0) {
                for (int i = 0; i < numBricks - 1; i++) {
                    brickList.add(Twox4);
                }
                brickList.add(Twox2);
                brickList.add(Twox2);
                sidesList.add(new Side(brickList, "sideA"));
                brickList = new ArrayList<Brick>();
                for (int i = 0; i < numBricks - 1; i++) {
                    brickList.add(Twox4);
                }
                brickList.add(Twox2);
                brickList.add(Twox2);
                sidesList.add(new Side(brickList, "sideC"));
                brickList = new ArrayList<Brick>();
            } else {
                int numBricks2 = numBricks / 2;
                for (int i = 0; i < numBricks2; i++) {
                    brickList.add(Twox4);
                }
                for (int i = 0; i < numBricks2 * 2; i++) {
                    brickList.add(Twox2);
                }
                sidesList.add(new Side(brickList, "sideA"));
                brickList = new ArrayList<Brick>();
                for (int i = 0; i < numBricks2; i++) {
                    brickList.add(Twox4);
                }
                for (int i = 0; i < numBricks2 * 2; i++) {
                    brickList.add(Twox2);
                }
                sidesList.add(new Side(brickList, "sideC"));
                brickList = new ArrayList<Brick>();
            }

        } else if (remaining == 1) {
            int numBricks = sidea / Twox4.getLength();
            brickList.add(Onex2);
            for (int i = 0; i < numBricks; i++) {
                brickList.add(Twox4);
            }
            sidesList.add(new Side(brickList, "sideA"));
            brickList = new ArrayList<Brick>();

            brickList.add(Onex2);
            for (int i = 0; i < numBricks; i++) {
                brickList.add(Twox4);
            }
            sidesList.add(new Side(brickList, "sideC"));
            brickList = new ArrayList<Brick>();

        } else if (remaining == 2) {
            int numBricks = sidea / Twox4.getLength();
            brickList.add(Twox2);
            for (int i = 0; i < numBricks; i++) {
                brickList.add(Twox4);
            }
            sidesList.add(new Side(brickList, "sideA"));
            brickList = new ArrayList<Brick>();

            brickList.add(Twox2);
            for (int i = 0; i < numBricks; i++) {
                brickList.add(Twox4);
            }
            sidesList.add(new Side(brickList, "sideC"));
            brickList = new ArrayList<Brick>();

        } else if (remaining == 3) {
            int numBricks = sidea / Twox4.getLength();
            brickList.add(Onex2);
            brickList.add(Twox2);
            for (int i = 0; i < numBricks; i++) {
                brickList.add(Twox4);
            }
            sidesList.add(new Side(brickList, "sideA"));
            brickList = new ArrayList<Brick>();

            brickList.add(Onex2);
            brickList.add(Twox2);
            for (int i = 0; i < numBricks; i++) {
                brickList.add(Twox4);
            }
            sidesList.add(new Side(brickList, "sideC"));
            brickList = new ArrayList<Brick>();
        }

        remaining = sideb % Twox4.getLength();
        if (remaining == 0) {
            int numBricks = sideb / Twox4.getLength();
            if (numBricks % 2 != 0) {
                if (numBricks >= 3) {
                    for (int i = 0; i < numBricks - 1; i++) {
                        brickList.add(Twox4);
                    }
                    brickList.add(Twox2);
                    brickList.add(Twox2);
                    sidesList.add(new Side(brickList, "sideB"));
                    brickList = new ArrayList<Brick>();
                    for (int i = 0; i < numBricks - 1; i++) {
                        brickList.add(Twox4);
                    }
                    brickList.add(Twox2);
                    brickList.add(Twox2);
                    sidesList.add(new Side(brickList, "sideD"));
                    brickList = new ArrayList<Brick>();
                } else {
                    numBricks = sideb / Twox2.getLength();
                    for (int i = 0; i < numBricks - 1; i++) {
                        brickList.add(Twox2);
                    }
                    brickList.add(Onex2);
                    brickList.add(Onex2);
                    sidesList.add(new Side(brickList, "sideB"));
                    brickList = new ArrayList<Brick>();
                    for (int i = 0; i < numBricks - 1; i++) {
                        brickList.add(Twox2);
                    }
                    brickList.add(Onex2);
                    sidesList.add(new Side(brickList, "sideD"));
                    brickList = new ArrayList<Brick>();
                }

            } else {
                if (numBricks <= 2) {
                    numBricks = sideb / Twox2.getLength();
                    for (int i = 0; i < numBricks / 2; i++) {
                        brickList.add(Twox2);
                    }
                    for (int i = 0; i < numBricks; i++) {
                        brickList.add(Onex2);
                    }
                    sidesList.add(new Side(brickList, "sideB"));
                    brickList = new ArrayList<Brick>();
                    for (int i = 0; i < numBricks / 2; i++) {
                        brickList.add(Twox2);
                    }
                    for (int i = 0; i < numBricks; i++) {
                        brickList.add(Onex2);
                    }
                    sidesList.add(new Side(brickList, "sideD"));
                    brickList = new ArrayList<Brick>();

                } else {
                    int numBricks2 = numBricks / 2;
                    for (int i = 0; i < numBricks2; i++) {
                        brickList.add(Twox4);
                    }
                    for (int i = 0; i < numBricks2 * 2; i++) {
                        brickList.add(Twox2);
                    }
                    sidesList.add(new Side(brickList, "sideB"));
                    brickList = new ArrayList<Brick>();
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

        } else if (remaining == 1) {
            int numBricks = sideb / Twox4.getLength();
            brickList.add(Onex2);
            for (int i = 0; i < numBricks; i++) {
                brickList.add(Twox4);
            }
            sidesList.add(new Side(brickList, "sideB"));
            brickList = new ArrayList<Brick>();

            brickList.add(Onex2);
            for (int i = 0; i < numBricks; i++) {
                brickList.add(Twox4);
            }
            sidesList.add(new Side(brickList, "sideD"));
            brickList = new ArrayList<Brick>();

        } else if (remaining == 2) {
            int numBricks = sideb / Twox4.getLength();
            brickList.add(Twox2);
            for (int i = 0; i < numBricks; i++) {
                brickList.add(Twox4);
            }
            sidesList.add(new Side(brickList, "sideB"));
            brickList = new ArrayList<Brick>();

            brickList.add(Twox2);
            for (int i = 0; i < numBricks; i++) {
                brickList.add(Twox4);
            }
            sidesList.add(new Side(brickList, "sideD"));
            brickList = new ArrayList<Brick>();

        } else if (remaining == 3) {
            int numBricks = sideb / Twox4.getLength();
            brickList.add(Onex2);
            brickList.add(Twox2);
            for (int i = 0; i < numBricks; i++) {
                brickList.add(Twox4);
            }
            sidesList.add(new Side(brickList, "sideB"));
            brickList = new ArrayList<Brick>();

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

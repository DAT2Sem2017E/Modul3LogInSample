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
                numBricks++;
                //here i dont run numBricks*2 because i just add equal parts 2x2 and 2x4 to the list
                //if i only wanted for 1 side i would've said numBricks/2
                for (int i = 0; i < numBricks / 2; i++) {
                    brickList.add(Twox4);
                    brickList.add(Twox2);
                }
                sidesList.add(new Side(brickList, "sideA"));
                brickList = new ArrayList<Brick>();
                for (int i = 0; i < numBricks / 2; i++) {
                    brickList.add(Twox4);
                    brickList.add(Twox2);
                }
                sidesList.add(new Side(brickList, "sideC"));
                brickList = new ArrayList<Brick>();
            } else {
                //jeg deler antallet af klodser op i 3 og smider så 2/3 dele af 2x4 i listen
                //og 1/3 dele af 2x2 i listen
                int numBricks2 = numBricks / 3;
                for (int i = 0; i < numBricks2 * 2; i++) {
                    brickList.add(Twox4);
                }
                for (int i = 0; i < numBricks2; i++) {
                    brickList.add(Twox2);
                }
                //og jeg gør det igen for den anden side af huset
                sidesList.add(new Side(brickList, "sideA"));
                brickList = new ArrayList<Brick>();
                for (int i = 0; i < numBricks2 * 2; i++) {
                    brickList.add(Twox4);
                }
                for (int i = 0; i < numBricks2; i++) {
                    brickList.add(Twox2);
                }
                sidesList.add(new Side(brickList, "sideC"));
                brickList = new ArrayList<Brick>();
            }

        } else if (remaining == 1) {
            brickList.add(Onex2);
            int numBricks = sidea / Twox4.getLength();
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
            brickList.add(Twox2);
            int numBricks = sidea / Twox4.getLength();
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
            brickList.add(Onex2);
            brickList.add(Twox2);
            int numBricks = sidea / Twox4.getLength();
            for (int i = 0; i < numBricks * 2; i++) {
                brickList.add(Twox4);
            }
            sidesList.add(new Side(brickList, "sideA"));
            brickList = new ArrayList<Brick>();

            brickList.add(Onex2);
            brickList.add(Twox2);
            for (int i = 0; i < numBricks * 2; i++) {
                brickList.add(Twox4);
            }
            sidesList.add(new Side(brickList, "sideC"));
            brickList = new ArrayList<Brick>();
        }

        remaining = sideb % Twox4.getLength();
        if (remaining == 0) {
            int numBricks = sidea / Twox4.getLength();
            if (numBricks % 2 != 0) {
                numBricks++;
                //here i dont run numBricks*2 because i just add equal parts 2x2 and 2x4 to the list
                //if i only wanted for 1 side i would've said numBricks/2
                for (int i = 0; i < numBricks / 2; i++) {
                    brickList.add(Twox4);
                    brickList.add(Twox2);
                }
                sidesList.add(new Side(brickList, "sideA"));
                brickList = new ArrayList<Brick>();
                for (int i = 0; i < numBricks / 2; i++) {
                    brickList.add(Twox4);
                    brickList.add(Twox2);
                }
                sidesList.add(new Side(brickList, "sideC"));
                brickList = new ArrayList<Brick>();
            } else {
                //jeg deler antallet af klodser op i 3 og smider så 2/3 dele af 2x4 i listen
                //og 1/3 dele af 2x2 i listen
                int numBricks2 = numBricks / 3;
                for (int i = 0; i < numBricks2 * 2; i++) {
                    brickList.add(Twox4);
                }
                for (int i = 0; i < numBricks2; i++) {
                    brickList.add(Twox2);
                }
                //og jeg gør det igen for den anden side af huset
                sidesList.add(new Side(brickList, "sideA"));
                brickList = new ArrayList<Brick>();
                for (int i = 0; i < numBricks2 * 2; i++) {
                    brickList.add(Twox4);
                }
                for (int i = 0; i < numBricks2; i++) {
                    brickList.add(Twox2);
                }
                sidesList.add(new Side(brickList, "sideC"));
                brickList = new ArrayList<Brick>();
            }

        } else if (remaining == 1) {
            brickList.add(Onex2);
            int numBricks = sidea / Twox4.getLength();
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
            brickList.add(Twox2);
            int numBricks = sidea / Twox4.getLength();
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
            brickList.add(Onex2);
            brickList.add(Twox2);
            int numBricks = sidea / Twox4.getLength();
            for (int i = 0; i < numBricks * 2; i++) {
                brickList.add(Twox4);
            }
            sidesList.add(new Side(brickList, "sideA"));
            brickList = new ArrayList<Brick>();

            brickList.add(Onex2);
            brickList.add(Twox2);
            for (int i = 0; i < numBricks * 2; i++) {
                brickList.add(Twox4);
            }
            sidesList.add(new Side(brickList, "sideC"));
            brickList = new ArrayList<Brick>();
        }

        return sidesList;
    }

}

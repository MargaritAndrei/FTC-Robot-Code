package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import java.lang.InterruptedException;

@Autonomous(name = "Autonomous Encoder")
public class RobotAutoEncoder extends LinearOpMode{
    int milisecunde, viteza,pozitie;
    DcMotorEx motor_front_left;
    DcMotorEx motor_front_right;
    DcMotorEx motor_back_left;
    DcMotorEx motor_back_right;
    DcMotor motor_ducks;
    DcMotorEx motor_crane;

    //Servo servocr;
    //Servo servocr_right;
    //Servo servocr_left;

    public void resetEncoders(){
        motor_front_left.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        motor_front_right.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        motor_back_left.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        motor_back_right.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void setPosition(int pozitie){

    }

    public void runPositionMode() {
        motor_front_left.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        motor_front_right.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        motor_back_left.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        motor_back_right.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
    }

    public void setVelocity(int viteza){
        motor_front_left.setVelocity(viteza);
        motor_front_right.setVelocity(viteza);
        motor_back_left.setVelocity(viteza);
        motor_back_right.setVelocity(viteza);
    }

    public void forward(int viteza,int pozitie) {
        resetEncoders();
        motor_front_left.setTargetPosition(-pozitie);
        motor_front_right.setTargetPosition(pozitie);
        motor_back_left.setTargetPosition(-pozitie);
        motor_back_right.setTargetPosition(pozitie);
        runPositionMode();
        setVelocity(viteza);
        while(motor_front_left.isBusy()&&motor_front_right.isBusy()&&
                motor_back_left.isBusy()&&motor_back_right.isBusy()){

        }
    }
    public void backward(int viteza,int pozitie) {
        resetEncoders();
        motor_front_left.setTargetPosition(pozitie);
        motor_front_right.setTargetPosition(-pozitie);
        motor_back_left.setTargetPosition(pozitie);
        motor_back_right.setTargetPosition(-pozitie);
        runPositionMode();
        setVelocity(viteza);
        while(motor_front_left.isBusy()&&motor_front_right.isBusy()&&
                motor_back_left.isBusy()&&motor_back_right.isBusy()){

        }
    }

    public void rotateleft(int viteza,int pozitie) {
        resetEncoders();
        motor_front_left.setTargetPosition(pozitie);
        motor_front_right.setTargetPosition(pozitie);
        motor_back_left.setTargetPosition(-pozitie);
        motor_back_right.setTargetPosition(-pozitie);
        runPositionMode();
        setVelocity(viteza);
        while(motor_front_left.isBusy()&&motor_front_right.isBusy()&&
                motor_back_left.isBusy()&&motor_back_right.isBusy()){

        }
    }

    public void rotateright(int viteza,int pozitie) {
        resetEncoders();
        motor_front_left.setTargetPosition(-pozitie);
        motor_front_right.setTargetPosition(-pozitie);
        motor_back_left.setTargetPosition(pozitie);
        motor_back_right.setTargetPosition(pozitie);
        runPositionMode();
        setVelocity(viteza);
        while(motor_front_left.isBusy()&&motor_front_right.isBusy()&&
                motor_back_left.isBusy()&&motor_back_right.isBusy()){

        }
    }

    public void left(int viteza,int pozitie) {
        resetEncoders();
        motor_front_left.setTargetPosition(pozitie);
        motor_front_right.setTargetPosition(pozitie);
        motor_back_left.setTargetPosition(pozitie);
        motor_back_right.setTargetPosition(pozitie);
        runPositionMode();
        setVelocity(viteza);
        while(motor_front_left.isBusy()&&motor_front_right.isBusy()&&
                motor_back_left.isBusy()&&motor_back_right.isBusy()){

        }
    }

    public void right(int viteza,int pozitie) {
        resetEncoders();
        motor_front_left.setTargetPosition(-pozitie);
        motor_front_right.setTargetPosition(-pozitie);
        motor_back_left.setTargetPosition(-pozitie);
        motor_back_right.setTargetPosition(-pozitie);
        runPositionMode();
        setVelocity(viteza);
        while(motor_front_left.isBusy()&&motor_front_right.isBusy()&&
                motor_back_left.isBusy()&&motor_back_right.isBusy()){

        }
    }

    public void stopmoving(){
        try {
            Thread.sleep(500);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public void duckdropper(long milisecunde){
        try {
            motor_ducks.setPower(-0.5);
            Thread.sleep(milisecunde);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    void assignComponents(){
        motor_front_left = hardwareMap.get(DcMotorEx.class,"motor_fl");
        motor_front_right = hardwareMap.get(DcMotorEx.class,"motor_fr");;
        motor_back_left = hardwareMap.get(DcMotorEx.class,"motor_bl");;
        motor_back_right = hardwareMap.get(DcMotorEx.class,"motor_br");;
        motor_ducks = hardwareMap.get(DcMotor.class, "motor_dks");
        motor_crane = hardwareMap.get(DcMotorEx.class, "motor_cr");

        motor_front_left.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        motor_front_right.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        motor_back_left.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        motor_back_right.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
    }

    @Override
    public void runOpMode(){
        assignComponents();
        resetEncoders();

        waitForStart();

        forward(2000,150);
        stopmoving();
        rotateleft(2000,650);
        stopmoving();
        forward(2000,1500);
        stopmoving();
        rotateright(2000,500);
        stopmoving();
        duckdropper(3000);
        stopmoving();
        forward(2000,300);
        stopmoving();
        rotateright(2000,1000);
        stopmoving();
        stop();
    }

}

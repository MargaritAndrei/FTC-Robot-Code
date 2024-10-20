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

@Autonomous(name = "Autonomous Movement")
public class RobotMovementAutonomous extends LinearOpMode{
    long milisecunde;

    DcMotor motor_front_left;
    DcMotor motor_front_right;
    DcMotor motor_back_left;
    DcMotor motor_back_right;
    DcMotor motor_ducks;
    DcMotorEx motor_crane;

    Servo servocr_right;
    Servo servocr_left;

    public void forward(long milisecunde) {
        try {
            motor_front_left.setPower(-0.85);
            motor_front_right.setPower(0.85);
            motor_back_left.setPower(-0.85);
            motor_back_right.setPower(0.85);
            Thread.sleep(milisecunde);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    public void backwards(long milisecunde) {
        try {
            motor_front_left.setPower(0.85);
            motor_front_right.setPower(-0.85);
            motor_back_left.setPower(0.85);
            motor_back_right.setPower(-0.85);
            Thread.sleep(milisecunde);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public void left(long milisecunde) {
        try {
            motor_front_left.setPower(0.5);
            motor_front_right.setPower(0.5);
            motor_back_left.setPower(-0.5);
            motor_back_right.setPower(-0.5);
            Thread.sleep(milisecunde);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public void right(long milisecunde) {
        try {
            motor_front_left.setPower(-0.5);
            motor_front_right.setPower(-0.5);
            motor_back_left.setPower(0.5);
            motor_back_right.setPower(0.5);
            Thread.sleep(milisecunde);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public void rotateleft(long milisecunde) {
        try {
            motor_front_left.setPower(0.5);
            motor_front_right.setPower(0.5);
            motor_back_left.setPower(-0.5);
            motor_back_right.setPower(-0.5);
            Thread.sleep(milisecunde);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public void rotateright(long milisecunde) {
        try {
            motor_front_left.setPower(-0.5);
            motor_front_right.setPower(-0.5);
            motor_back_left.setPower(0.5);
            motor_back_right.setPower(0.5);
            Thread.sleep(milisecunde);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public void stopmoving(long milisecunde){
        try {
            motor_front_left.setPower(0);
            motor_front_right.setPower(0);
            motor_back_left.setPower(0);
            motor_back_right.setPower(0);
            motor_ducks.setPower(0);
            Thread.sleep(milisecunde);
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

    /*
    public void crane(){
        //autonomus fixed position
        /*while(opModeIsActive()) {
            motor_crane.setPower(0.1);
        }

        //teleop
        while(opModeIsActive()){
            motor_crane.setPower(1/ 1.15);
        }
    }
    */

    public void holdCube(long milisecunde){
        try {
            // Picking position
            servocr_left.setPosition(0.1);
            servocr_right.setDirection(Servo.Direction.FORWARD);
            servocr_right.setPosition(0.9);

            telemetry.addData("count", servocr_left.getPosition());
            telemetry.addData("count", servocr_left.getDirection());
            telemetry.addData("count2", servocr_right.getPosition());
            telemetry.addData("count2", servocr_right.getDirection());
            telemetry.update();

            Thread.sleep(milisecunde);
        }
        catch (Exception e) {
            System.out.println(e);
        }

    }

    public void releaseCube(long milisecunde){
        try {
            // Idle position
            servocr_left.setPosition(0);
            servocr_right.setDirection(Servo.Direction.REVERSE);
            servocr_right.setPosition(0);

            telemetry.addData("count", servocr_left.getPosition());
            telemetry.addData("count", servocr_left.getDirection());
            telemetry.addData("count2", servocr_right.getPosition());
            telemetry.addData("count2", servocr_right.getDirection());
            telemetry.update();

            Thread.sleep(milisecunde);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    void assignComponents(){
        motor_front_left = hardwareMap.get(DcMotor.class,"motor_fl");
        motor_front_right = hardwareMap.get(DcMotor.class,"motor_fr");;
        motor_back_left = hardwareMap.get(DcMotor.class,"motor_bl");;
        motor_back_right = hardwareMap.get(DcMotor.class,"motor_br");;
        motor_ducks = hardwareMap.get(DcMotor.class, "motor_dks");
        motor_crane = hardwareMap.get(DcMotorEx.class, "motor_cr");
        servocr_right = hardwareMap.servo.get("dckservo0");
        servocr_left = hardwareMap.servo.get("dckservo1");
    }

    @Override
    public void runOpMode(){
        assignComponents();

        waitForStart();
        forward(100);
        stopmoving(1000);
        rotateleft(625);
        stopmoving(1000);
        forward(500);
        stopmoving(1000);
        rotateright(300);
        stopmoving(1000);
        duckdropper(3000);
        stopmoving(1000);
        rotateleft(350);
        stopmoving(1000);
        backwards(100);
        stopmoving(1000);
        rotateright(100);
        stopmoving(1000);
        backwards(2350);
        //forwards(2000);

        /*
        forward(200);
        stopmoving(1000);
        rotateright(600);
        //holdCube(3000);
        //releaseCube(1000);
        //crane();
        forward(1450);
         */
        stop();
    }

}

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name = "Controller Movement")
public class RobotMovement extends OpMode{

    DcMotor motor_front_left;
    DcMotor motor_front_right;
    DcMotor motor_back_left;
    DcMotor motor_back_right;
    DcMotor motor_crane;
    DcMotor motor_ducks;

    Servo servocr;

    public void forwards(){
        if(gamepad1.dpad_up){
            motor_front_left.setPower(-0.85);
            motor_front_right.setPower(0.85);
            motor_back_left.setPower(-0.85);
            motor_back_right.setPower(0.85);
        }
        else{
            motor_front_left.setPower(0);
            motor_front_right.setPower(0);
            motor_back_left.setPower(0);
            motor_back_right.setPower(0);
        }
    }

    public void backwards(){
        if(gamepad1.dpad_down){
            motor_front_left.setPower(0.85);
            motor_front_right.setPower(-0.85);
            motor_back_left.setPower(0.85);
            motor_back_right.setPower(-0.85);
        }
        else{
            motor_front_left.setPower(0);
            motor_front_right.setPower(0);
            motor_back_left.setPower(0);
            motor_back_right.setPower(0);
        }
    }

    public void right(){
        if(gamepad1.dpad_right){
            motor_front_left.setPower(-0.85);
            motor_front_right.setPower(-0.85);
            motor_back_left.setPower(-0.85);
            motor_back_right.setPower(-0.85);
        }
        else{
            motor_front_left.setPower(0);
            motor_front_right.setPower(0);
            motor_back_left.setPower(0);
            motor_back_right.setPower(0);
        }
    }

    public void left(){
        if(gamepad1.dpad_left){
            motor_front_left.setPower(0.85);
            motor_front_right.setPower(0.85);
            motor_back_left.setPower(0.85);
            motor_back_right.setPower(0.85);
        }
        else{
            motor_front_left.setPower(0);
            motor_front_right.setPower(0);
            motor_back_left.setPower(0);
            motor_back_right.setPower(0);
        }
    }

    public void rotateleft() {
        if(gamepad1.left_bumper)
        {
            motor_front_left.setPower(0.85);
            motor_front_right.setPower(0.85);
            motor_back_left.setPower(-0.85);
            motor_back_right.setPower(-0.85);
        }
        else
        {
            motor_front_left.setPower(0);
            motor_front_right.setPower(0);
            motor_back_left.setPower(0);
            motor_back_right.setPower(0);
        }
        /*
        motor_front_left.setPower(gamepad1.left_trigger);
        motor_front_right.setPower(gamepad1.left_trigger);
        motor_back_left.setPower(gamepad1.left_trigger);
        motor_back_right.setPower(gamepad1.left_trigger);
         */
    }

    public void rotateright() {
        if(gamepad1.right_bumper)
        {
            motor_front_left.setPower(-0.85);
            motor_front_right.setPower(-0.85);
            motor_back_left.setPower(0.85);
            motor_back_right.setPower(0.85);
        }
        else
        {
            motor_front_left.setPower(0);
            motor_front_right.setPower(0);
            motor_back_left.setPower(0);
            motor_back_right.setPower(0);
        }
        /*
        motor_front_left.setPower(-gamepad1.right_trigger);
        motor_front_right.setPower(-gamepad1.right_trigger);
        motor_back_left.setPower(-gamepad1.right_trigger);
        motor_back_right.setPower(-gamepad1.right_trigger);
         */
    }

    public void cranemovement(){
        motor_crane.setPower(-gamepad2.right_stick_y / 1.5);
    }

    public void duckdropper(){
        if(gamepad2.x)
        {
            motor_ducks.setPower(-0.5);
        }
        else
        {
            motor_ducks.setPower(0);
        }
    }

    public void servoduckspick(){
        /*if(gamepad2.b){
            // Picking position
            servocr.setDirection(Servo.Direction.REVERSE);
            servocr.setPosition(0.3);
        }
        else {
            servocr.setDirection(Servo.Direction.FORWARD);
            servocr.setPosition(0.9);
        }

         */
        boolean goingdown = false;
        boolean goingup = false;

        if(gamepad2.dpad_up){
            servocr.setDirection(Servo.Direction.REVERSE);
            goingup = true;
            servocr.setPosition(0.9);
        }
        else if(gamepad2.dpad_down){
            servocr.setDirection(Servo.Direction.FORWARD);
            goingdown = true;
            servocr.setPosition(0.5);
        }
        else{
            if(goingup){
                servocr.setPosition(0);
            }
            if(goingdown){
                servocr.setPosition(0);
            }
        }

        //servocr.setPosition(gamepad2.left_stick_y);
        telemetry.addData("count", servocr.getPosition());
        telemetry.addData("count", servocr.getDirection());
        telemetry.update();
    }

    @Override
    public void init(){

        // Control Hub Motors
        motor_front_left = hardwareMap.get(DcMotor.class,"motor_fl");
        motor_front_right = hardwareMap.get(DcMotor.class,"motor_fr");
        motor_back_left = hardwareMap.get(DcMotor.class,"motor_bl");
        motor_back_right = hardwareMap.get(DcMotor.class,"motor_br");

        // Expanision Hub Motors
        motor_crane = hardwareMap.get(DcMotor.class, "motor_cr");
        motor_ducks = hardwareMap.get(DcMotor.class, "motor_dks");


        // Crane Servos
        servocr = hardwareMap.servo.get("dckservo0");

    }

    @Override
    public void loop(){
        forwards();
        backwards();
        left();
        right();
        rotateleft();
        rotateright();

        cranemovement();
        duckdropper();
        servoduckspick();
    }
}

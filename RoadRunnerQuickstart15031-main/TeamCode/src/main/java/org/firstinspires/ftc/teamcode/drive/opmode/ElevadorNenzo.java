package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import java.util.Timer;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@TeleOp(name = "ElevadorNenzo")

public class ElevadorNenzo extends LinearOpMode {

    DcMotor elevador;
    DcMotor elevador2;
    double elevadorPower = 0;
    double elevador2Power = 0;

    double kP = 0.1;
    double kI = 0.01;
    double kD = 0.01;
    double f = 0.0;
    double ticks_in_degree = 360 / 28.0;
    ElapsedTime timer = new ElapsedTime();

    double setPoint = 0;
    double lastError = 0;
    double integral = 0;
    double lastTimestamp = 0;

    @Override
    public void runOpMode() {
        lastTimestamp = timer.seconds();
        elevador = hardwareMap.dcMotor.get("elevador");
        elevador.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        elevador.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        lastTimestamp = timer.seconds();
        elevador2 = hardwareMap.dcMotor.get("elevador2");
        elevador2.setDirection(DcMotor.Direction.REVERSE);
        elevador2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        elevador2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        waitForStart();

        while (opModeIsActive()) {

            elevador.setPower(gamepad1.right_trigger-gamepad1.left_trigger);
            elevador2.setPower(gamepad1.right_trigger-gamepad1.left_trigger);
        }
    }
}

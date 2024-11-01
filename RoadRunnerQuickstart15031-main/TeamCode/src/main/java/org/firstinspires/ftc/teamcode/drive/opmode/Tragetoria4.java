package org.firstinspires.ftc.teamcode.drive.opmode;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

@Config
@Autonomous
public class Tragetoria4 extends LinearOpMode {

    @Override
    public void runOpMode() {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        // Cria uma trajetória com o método correto
        drive.setPoseEstimate(new Pose2d(59, 47, Math.toRadians(90)));
        TrajectorySequence trajectory0 = drive.trajectorySequenceBuilder(new Pose2d(59, 47, Math.toRadians(-61.97)))
                .splineTo(new Vector2d(44, 66), Math.toRadians(-51.27))
                .splineTo(new Vector2d(9, 57), Math.toRadians(-51.95))
                .splineTo(new Vector2d(0, 91), Math.toRadians(-33.95))
                .build();

        // Aguardar o início do modo autônomo
        waitForStart();

        if (isStopRequested()) return;

        // Seguir a trajetória criada
        drive.followTrajectorySequence(trajectory0);
    }
}

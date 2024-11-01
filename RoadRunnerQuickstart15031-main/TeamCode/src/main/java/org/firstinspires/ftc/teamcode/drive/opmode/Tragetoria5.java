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
public class Tragetoria5 extends LinearOpMode {

    @Override
    public void runOpMode() {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        // Cria uma trajetória com o método correto
        drive.setPoseEstimate(new Pose2d(59, -66.08, Math.toRadians(90)));
        TrajectorySequence trajectory0 = drive.trajectorySequenceBuilder(new Pose2d(60.84, -61.97, Math.toRadians(90.00)))
                .splineTo(new Vector2d(0.23, -33.04), Math.toRadians(90.00))
                .build();
        TrajectorySequence trajectory1 = drive.trajectorySequenceBuilder(new Pose2d(0.00, -46.04, Math.toRadians(90.00)))
                .splineTo(new Vector2d(35.44, -45.59), Math.toRadians(0.73))
                .splineTo(new Vector2d(37.24, -30.92), Math.toRadians(104.04))
                .splineToConstantHeading(new Vector2d(35.21, -4.06), Math.toRadians(90.00))
                .splineToConstantHeading(new Vector2d(50.11, -5.19), Math.toRadians(-1.08))
                .splineTo(new Vector2d(47.85, -29.79), Math.toRadians(-88.88))
                .splineToLinearHeading(new Pose2d(47.85, -57.33, Math.toRadians(90.00)), Math.toRadians(90.00))
                .build();



        // Aguardar o início do modo autônomo
        waitForStart();

        if (isStopRequested()) return;

        // Seguir a trajetória criada
        drive.followTrajectorySequence(trajectory0);
        drive.followTrajectorySequence(trajectory1);

    }
}

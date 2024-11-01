package org.firstinspires.ftc.teamcode.drive.opmode;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

@Config
@Autonomous

public class Tragetoria3 extends LinearOpMode {

    @Override
    public void runOpMode() {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        Vector2d targetPosition = new Vector2d(10, 10);
        Vector2d targetPosition2 = new Vector2d(-15, -20);

        Trajectory traj1 = drive.trajectoryBuilder(new Pose2d())
                .lineTo(targetPosition)
                .build();
        Trajectory traj2 = drive.trajectoryBuilder(new Pose2d())
                .lineTo(targetPosition2)
                .build();
        waitForStart();

        if (isStopRequested()) return;

        drive.followTrajectory(traj1);
        drive.followTrajectory(traj2);
    }
}

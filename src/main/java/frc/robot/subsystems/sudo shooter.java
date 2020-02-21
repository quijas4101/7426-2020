//Main
double farStart = .85; // initial motor speed for far shot
double closeStart = .65; // initial motor speed for close shot
double targetFar = 5800; // Target velocity speed for far shot. these numbers will be changed once we see what numbers we get from encoderVelocity
double targetClose = 3800; // Target velocity speed for close shot

// just assuming if the pnuematics of shooter are pulled the shooterPnumatic boolean will be true
if (shooterPnuematic == true) {
    shooter.SetPower(Joystick.getTrigger(),farStart, targetFar );
} else {
    shooter.SetPower(Joystick.getTrigger(),closeStart, targetClose );
}



// inside shooter
CANEncoder encoder;

encoder = ShMotor1.getEncoder();

void SetPower(boolean Enabled, double Power, double target){
    if(Enabled){
        shooterObj.set(Power);
        while((encoder.getVelocity() < target) && Enabled){
            Power += .005;
            shooterObj.set(Power);
        }
        while((encoder.getVelocity() >= target) && Enabled){
            //WE SHOOT !!!!!!!!! Lights or dashboard message
        }
    }else {
        shooterObj.set(0);
    }

}

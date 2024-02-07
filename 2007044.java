//Bridge pattern is used beacuse it is used to decouple an abstraction from its implementation so that the two can vary independently.
//In this example, we have an interface device and two classes tv and radio implementing the device interface.
//We have a remoteControl class which has a device object and has methods to control the device.
//so i omplemented the bridge pattern in this example.


//interface device is implemented for tv and radio classes.
interface device {
    boolean isEnabled();
    void enable();
    void disable();
    int getVolume();
    void setVolume(int percent);
    int getChannel();
    void setChannel(int channel);
}
//tv and radio classes are implementing the device interface
class tv implements device {
    private boolean powerOn;
    private int volume;
    private int channel;
    //override is used beacuse i am implementing the methods of interface device
    @Override
    public boolean isEnabled() {
        return powerOn;
    }
    @Override
    public void enable() {
        powerOn=true;
    }
    @Override
    public void disable() {
        powerOn=false;
    }
    @Override
    public int getVolume() {
        return volume;
    }
    @Override
    public void setVolume(int percent) {
        this.volume=percent;
    }
    @Override
    public int getChannel() {
        return channel;
    }
    @Override
    public void setChannel(int channel) {
        this.channel=channel;
    }
}
//tv and radio classes are implementing the device interface
class radio implements device {
    private boolean powerOn;
    private int volume;
    private int channel;
    @Override
    public boolean isEnabled() {
        return powerOn;
    }
    @Override
    public void enable() {
        powerOn=true;
    }
    @Override
    public void disable() {
        powerOn=false;
    }
    @Override
    public int getVolume() {
        return volume;
    }
    @Override
    public void setVolume(int percent) {
        this.volume=percent;
    }
    @Override
    public int getChannel() {
        return channel;
    }
    @Override
    public void setChannel(int channel) {
        this.channel=channel;
    }
}
class remoteControl {
    protected device device;
    public remoteControl(device device) {
        this.device = device;
    }
    public void togglePower() {
        if (device.isEnabled()) {
            device.disable();
        } else {
            device.enable();
        }
    }
    public void volumeDown() {
        device.setVolume(device.getVolume()-10);
    }
    public void volumeUp() {
        device.setVolume(device.getVolume()+10);
    }
    public void channelDown() {
        device.setChannel(device.getChannel()-1);
    }
    public void channelUp() {
        device.setChannel(device.getChannel()+1);
    }
}
class advancedRemoteControl extends remoteControl {
    public advancedRemoteControl(device device) {
        super(device);
    }
    public void mute() {
        device.setVolume(0);
    }
}
public class lab4 {
    public static void main(String[] args) {
        tv tv = new tv();
        //remoteControl class object is created and tv object is passed to it.
        remoteControl basicRemote = new remoteControl(tv);
        basicRemote.togglePower();
        basicRemote.volumeUp();
        basicRemote.channelUp();
        //tv object is used to get the volume and channel.
        System.out.println("TV volume: " + tv.getVolume());
        radio radio = new radio();
        //advancedRemoteControl class object is created and radio object is passed to it.
        advancedRemoteControl advancedRemote = new advancedRemoteControl(radio);
        advancedRemote.togglePower();
        advancedRemote.mute();
        System.out.println("Radio volume: " + radio.getVolume());
    }
}
//this is how i implemented the bridge pattern in this example
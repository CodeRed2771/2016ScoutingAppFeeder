package com.coderedrobotics.scouting;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Michael
 */
public class Network {

    Socket socket;
    BufferedOutputStream output;
    BufferedInputStream input;

    public Network(String address, int port) throws IOException {
        socket = new Socket(address, port);
        output = new BufferedOutputStream(socket.getOutputStream());
        input = new BufferedInputStream(socket.getInputStream());
    }

    public void sendData(boolean autoReach, boolean autoLowGoal, boolean autoHighGoal,
            boolean autoPortcullis, boolean autoChivalDeFrise, boolean autoMoat,
            boolean autoRamparts, boolean autoDrawBridge, boolean autoSallyPort,
            boolean autoRockWall, boolean autoRoughTerrain, boolean autoLowBar,
            boolean lowGoal, int made, int missed, boolean portcullis,
            boolean chivalDeFrise, boolean moat, boolean ramparts, boolean drawBridge,
            boolean sallyPort, boolean rockWall, boolean roughTerrain, boolean lowBar,
            boolean challenge, boolean attemptedScale, boolean successfullyScaledTower,
            int speed, boolean broken, boolean gameRules, String notes, int team) throws IOException {
        notes = notes == null ? "" : notes; // replace null with ""
        output.write(PrimitiveSerializer.toByteArray(team));
        output.write(PrimitiveSerializer.toByteArray(autoReach));
        output.write(PrimitiveSerializer.toByteArray(autoLowGoal));
        output.write(PrimitiveSerializer.toByteArray(autoHighGoal));
        output.write(PrimitiveSerializer.toByteArray(autoPortcullis));
        output.write(PrimitiveSerializer.toByteArray(autoChivalDeFrise));
        output.write(PrimitiveSerializer.toByteArray(autoMoat));
        output.write(PrimitiveSerializer.toByteArray(autoRamparts));
        output.write(PrimitiveSerializer.toByteArray(autoDrawBridge));
        output.write(PrimitiveSerializer.toByteArray(autoSallyPort));
        output.write(PrimitiveSerializer.toByteArray(autoRockWall));
        output.write(PrimitiveSerializer.toByteArray(autoRoughTerrain));
        output.write(PrimitiveSerializer.toByteArray(autoLowBar));
        output.write(PrimitiveSerializer.toByteArray(lowGoal));
        output.write(PrimitiveSerializer.toByteArray(made));
        output.write(PrimitiveSerializer.toByteArray(missed));
        output.write(PrimitiveSerializer.toByteArray(portcullis));
        output.write(PrimitiveSerializer.toByteArray(chivalDeFrise));
        output.write(PrimitiveSerializer.toByteArray(moat));
        output.write(PrimitiveSerializer.toByteArray(ramparts));
        output.write(PrimitiveSerializer.toByteArray(drawBridge));
        output.write(PrimitiveSerializer.toByteArray(sallyPort));
        output.write(PrimitiveSerializer.toByteArray(rockWall));
        output.write(PrimitiveSerializer.toByteArray(roughTerrain));
        output.write(PrimitiveSerializer.toByteArray(lowBar));
        output.write(PrimitiveSerializer.toByteArray(challenge));
        output.write(PrimitiveSerializer.toByteArray(attemptedScale));
        output.write(PrimitiveSerializer.toByteArray(successfullyScaledTower));
        output.write(PrimitiveSerializer.toByteArray(speed));
        output.write(PrimitiveSerializer.toByteArray(broken));
        output.write(PrimitiveSerializer.toByteArray(gameRules));
        output.write(PrimitiveSerializer.toByteArray((short) PrimitiveSerializer.toByteArray(notes).length));
        output.write(PrimitiveSerializer.toByteArray(notes));
        output.flush();
    }
}

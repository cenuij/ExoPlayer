/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.android.exoplayer2.source.iptv;

import java.io.IOException;

public interface IptvLostPacketRecoverySource extends IptvChannelSource {

    String URI_LOST_PACKET_RECOVERY_SERVER_PARAMETER_ID = "lpr_server";

    interface EventListener {

        void onLostPacketRecoveryLoadCanceled();
        void onLostPacketRecoveryLoadError();

        void onLostPacketRecoveryStreamInfoRefresh(int sequenceNumber);
    }

    void setSsrcSource(long ssrc);

    int getCurrentSequenceNumber();
    long getCurrentTimeStamp();

    void notifyLostPacket(int sequence, int numLostPackets) throws IOException;

    void resetRecovery();
    int getMaxPacketLossAcceptable();
}

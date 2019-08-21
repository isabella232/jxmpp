/**
 *
 * Copyright 2019 Florian Schmaus
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jxmpp.strings.testframework;

import org.jxmpp.jid.Jid;
import org.jxmpp.stringprep.XmppStringprepException;

public abstract class InvalidJidTestresult {

	public final XmppStringPrepper xmppStringPrepper;
	public final InvalidJid invalidJid;

	protected InvalidJidTestresult(XmppStringPrepper xmppStringPrepper, InvalidJid invalidJid) {
		this.xmppStringPrepper = xmppStringPrepper;
		this.invalidJid = invalidJid;
	}

	public static class Successful extends InvalidJidTestresult {

		public final XmppStringprepException xmppStringprepException;

		protected Successful(XmppStringPrepper xmppStringPrepper, InvalidJid invalidJid,
				XmppStringprepException xmppStringprepException) {
			super(xmppStringPrepper, invalidJid);
			this.xmppStringprepException = xmppStringprepException;
		}

	}

	public static class Failed extends InvalidJidTestresult {

		public final Jid jid;

		protected Failed(XmppStringPrepper xmppStringPrepper, InvalidJid invalidJid, Jid jid) {
			super(xmppStringPrepper, invalidJid);
			this.jid = jid;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(xmppStringPrepper)
			.append(" failed to handle the following invalid JID:\n")
			.append(invalidJid).append('\n')
			.append("as it produced the following JID (when it should have thrown an exception):\n")
			.append(jid).append('\n');
			return sb.toString();
		}
	}

}
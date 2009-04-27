/* ========================================================================
 * PlantUML : a free UML diagram generator
 * ========================================================================
 *
 * (C) Copyright 2009, Arnaud Roques (for Atos Origin).
 *
 * Project Info:  http://plantuml.sourceforge.net
 * 
 * This file is part of PlantUML.
 *
 * PlantUML is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PlantUML distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 *
 * [Java is a trademark or registered trademark of Sun Microsystems, Inc.
 * in the United States and other countries.]
 *
 * Original Author:  Arnaud Roques (for Atos Origin).
 *
 */
package net.sourceforge.plantuml.classdiagram.command;

import java.util.List;

import net.sourceforge.plantuml.SingleLineCommand;
import net.sourceforge.plantuml.classdiagram.ClassDiagram;
import net.sourceforge.plantuml.cucadiagram.EntityType;

public class CommandCreateEntity extends SingleLineCommand<ClassDiagram> {

	public CommandCreateEntity(ClassDiagram classDiagram) {
		super(classDiagram, "(?i)^(usecase|interface|actor|component|note|class)\\s+(?:\"([^\"]+)\"\\s+as\\s+)?(\\w+)(?:\\s*(\\<\\<.*\\>\\>))?$");
	}

	protected boolean executeArg(List<String> arg) {
		final EntityType type = EntityType.valueOf(arg.get(0).toUpperCase());
		final String code = arg.get(2);
		final String display = arg.get(1);
		final String stereotype = arg.get(3);
		getSystem().createEntity(code, display, type, stereotype);
		return true;
	}

}
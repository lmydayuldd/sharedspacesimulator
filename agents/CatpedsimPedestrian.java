package uk.org.catapult.ts.cav.microsimulator.pedestrian.catpedsim.agents;

import java.awt.Color;
import java.util.LinkedList;

import com.sun.javafx.geom.Vec3f;

import processing.core.PVector;
import uk.org.catapult.ts.cav.microsimulator.pedestrian.catpedsim.configuration.geometry.CatpedsimCrossing;
import uk.org.catapult.ts.cav.microsimulator.pedestrian.catpedsim.configuration.geometry.CatpedsimTransitionZone;
import uk.org.catapult.ts.cav.microsimulator.pedestrian.catpedsim.configuration.path.XmlVertex;
import uk.org.catapult.ts.cav.microsimulator.pedestrian.catpedsim.shortestpath.NodePath;
import uk.org.catapult.ts.cav.model.identifier.StringIdentifier;

/**
 * The pedestrian class with information about location, velocity, acceleration.
 * 
 * @author Ecaterina McCormick, ecaterina.mccormick@ts.catapult.org.uk
 * 
 *         Copyright � <2016> TRANSPORT SYSTEMS CATAPULT
 * 
 *         Permission is hereby granted, free of charge, to any person obtaining
 *         a copy of this software and associated documentation files (the
 *         "Software"), to deal in the Software without restriction, including
 *         without limitation the rights to use, copy, modify, merge, publish,
 *         distribute, sublicense, and/or sell copies of the Software, and to
 *         permit persons to whom the Software is furnished to do so, subject to
 *         the following conditions:
 * 
 *         The above copyright notice and this permission notice shall be
 *         included in all copies or substantial portions of the Software. Users
 *         of the Software shall acknowledge Transport Systems Catapult as the
 *         source of the Software in any publication that refers to it.
 * 
 *         THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *         EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *         MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *         NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS
 *         BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
 *         ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 *         CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *         SOFTWARE.
 *
 */
public class CatpedsimPedestrian extends CatpedsimAgent {

	/**
	 * Constructor.
	 * 
	 * @param newPublisherId
	 *            publisher id
	 * @param newName
	 *            name of the pedestrian
	 * @param unewUniqueIdentifier
	 *            unique pedestrian identifier
	 * @param agentPosition3D
	 *            agent x coordinate, agent y coordinate, agent z coordinate in
	 *            floating point precision
	 * @param newMaximumSpeed
	 *            maximum speed
	 */
	public CatpedsimPedestrian(final String newPublisherId, final String newName,
			final StringIdentifier unewUniqueIdentifier, final Vec3f agentPosition3D, final float newMaximumSpeed) {
		super(newPublisherId, newName, unewUniqueIdentifier, agentPosition3D, newMaximumSpeed);

		setRadius(PedestrianConstraints.RADIUS);
		setRelaxationTime(PedestrianConstraints.RELAXATION_TIME);
		setWallRepulsionRadius(PedestrianConstraints.WALL_REPULSION_RADIUS);
		setWallRepulsionMagnitude(PedestrianConstraints.WALL_REPULSION_MAGNITUDE_U);
		setMaxForce(PedestrianConstraints.MAX_FORCE);
	}

	/**
	 * Constructor.
	 * 
	 * @param publisherId
	 *            publisher id
	 * @param agentName
	 *            name of the pedestrian
	 * @param uniqueIdentifier
	 *            unique pedestrian identifier
	 * @param agentPosition3D
	 *            agent x coordinate, agent y coordinate, agent z coordinate in
	 *            floating point precision
	 * @param maximumVelocity
	 *            maximum speed
	 * @param exit
	 *            exit line
	 */
	public CatpedsimPedestrian(final String publisherId, final String agentName,
			final StringIdentifier uniqueIdentifier, final Vec3f agentPosition3D, final float maximumVelocity,
			final CatpedsimCrossing exit) {
		this(publisherId, agentName, uniqueIdentifier, agentPosition3D, maximumVelocity);
		setAgentExit(exit);
	}

	/**
	 * Constructor.
	 * 
	 * @param publisherId
	 *            publisher id
	 * @param agentName
	 *            name of the pedestrian
	 * @param uniqueIdentifier
	 *            unique pedestrian identifier
	 * @param agentPosition3D
	 *            agent x coordinate, agent y coordinate, agent z coordinate in
	 *            floating point precision
	 * @param maximumVelocity
	 *            maximum speed
	 * @param exit
	 *            exit line
	 * @param color
	 *            agent color
	 */
	public CatpedsimPedestrian(final String publisherId, final String agentName,
			final StringIdentifier uniqueIdentifier, final Vec3f agentPosition3D, final float maximumVelocity,
			final CatpedsimCrossing exit, final Color color) {

		this(publisherId, agentName, uniqueIdentifier, agentPosition3D, maximumVelocity, exit);
		setColorToRepresent(color);
	}

	/**
	 * Constructor.
	 * 
	 * @param publisherId
	 *            publisher id
	 * @param agentName
	 *            name of the pedestrian
	 * @param uniqueIdentifier
	 *            unique pedestrian identifier
	 * @param agentPosition3D
	 *            agent x coordinate, agent y coordinate, agent z coordinate in
	 *            floating point precision
	 * @param maximumVelocity
	 *            maximum speed
	 * @param transitZone
	 *            moving towards the transit zone
	 * @param color
	 *            agent color
	 */
	public CatpedsimPedestrian(final String publisherId, final String agentName,
			final StringIdentifier uniqueIdentifier, final Vec3f agentPosition3D, final float maximumVelocity,
			final CatpedsimTransitionZone transitZone, final Color color) {

		this(publisherId, agentName, uniqueIdentifier, agentPosition3D, maximumVelocity);
		setColorToRepresent(color);
		setTransitionZone(transitZone);
	}

	/**
	 * Constructor.
	 * 
	 * @param publisherId
	 *            publisher id
	 * @param agentName
	 *            name of the pedestrian
	 * @param uniqueIdentifier
	 *            unique pedestrian identifier
	 * @param agentPosition3D
	 *            agent x coordinate, agent y coordinate, agent z coordinate in
	 *            floating point precision
	 * @param maximumVelocity
	 *            maximum speed
	 * @param transition
	 *            agent's destination is a transition area
	 * @param color
	 *            agent color
	 * @param preDefinedBehaviour
	 *            agent pre-defined behavoiur
	 */
	public CatpedsimPedestrian(final String publisherId, final String agentName,
			final StringIdentifier uniqueIdentifier, final Vec3f agentPosition3D, final float maximumVelocity,
			final CatpedsimTransitionZone transition, final Color color, final AgentBehaviour preDefinedBehaviour) {

		this(publisherId, agentName, uniqueIdentifier, agentPosition3D, maximumVelocity);

		setColorToRepresent(color);
		setSequenceOfBehaviours(preDefinedBehaviour);
		setTransitionZone(transition);

		XmlVertex target = preDefinedBehaviour.getCurrentBehaviour().getLast();
		if (target != null) {
			PVector exitVector = new PVector(target.getX(), target.getY());
			setVectorToAgentsTarget(exitVector);
		}
	}

	/**
	 * Constructor.
	 * 
	 * @param publisherId
	 *            publisher id
	 * @param agentName
	 *            name of the pedestrian
	 * @param uniqueIdentifier
	 *            unique pedestrian identifier
	 * @param agentPosition3D
	 *            agent x coordinate, agent y coordinate, agent z coordinate in
	 *            floating point precision
	 * @param maximumVelocity
	 *            maximum speed
	 * @param exit
	 *            exit line
	 * @param color
	 *            agent color
	 * @param path
	 *            path calculated with a*
	 */
	public CatpedsimPedestrian(final String publisherId, final String agentName,
			final StringIdentifier uniqueIdentifier, final Vec3f agentPosition3D, final float maximumVelocity,
			final CatpedsimCrossing exit, final Color color, final LinkedList<NodePath> path) {
		this(publisherId, agentName, uniqueIdentifier, agentPosition3D, maximumVelocity, exit);

		setColorToRepresent(color);
		setPathToFollow(path);
	}

	/**
	 * Constructor.
	 * 
	 * @param publisherId
	 *            publisher id
	 * @param agentName
	 *            name of the pedestrian
	 * @param uniqueIdentifier
	 *            unique pedestrian identifier
	 * @param agentPosition3D
	 *            agent x coordinate, agent y coordinate, agent z coordinate in
	 *            floating point precision
	 * @param maximumVelocity
	 *            maximum speed
	 * @param exit
	 *            agent exit area
	 * @param color
	 *            agent color
	 * @param preDefinedBehaviour
	 *            pre-defined agent behaviour
	 */
	public CatpedsimPedestrian(final String publisherId, final String agentName,
			final StringIdentifier uniqueIdentifier, final Vec3f agentPosition3D, final float maximumVelocity,
			final CatpedsimCrossing exit, final Color color, final AgentBehaviour preDefinedBehaviour) {

		this(publisherId, agentName, uniqueIdentifier, agentPosition3D, maximumVelocity, exit);

		setColorToRepresent(color);
		setSequenceOfBehaviours(preDefinedBehaviour);
	}

}
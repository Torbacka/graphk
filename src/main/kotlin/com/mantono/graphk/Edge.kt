package com.mantono.graphk

data class Edge<T: Any>(val source: T, val destination: T, val weight: Double): Comparable<Edge<T>>
{
	override fun equals(obj: Any?): Boolean
	{
		if (obj == null || obj.javaClass != this.javaClass)
			return false
		val other = obj as Edge<T>
		val sameWeight = this.weight == other.weight
		val sameSource = this.source == other.source
		val sameDestination = this.destination == other.destination
		return sameSource && sameDestination && sameWeight
	}

	override fun hashCode(): Int
	{
		val prime = 17
		var code: Double = prime * weight
		code = code * prime + source.hashCode()
		code = code * prime + destination.hashCode()
		return code.toInt()
	}

	override fun toString(): String = "$source -- $weight --> $destination"
	override fun compareTo(other: Edge<T>): Int = java.lang.Double.compare(this.weight, other.weight)
}
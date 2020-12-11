class Coordinate
{
	int sheepPos=0,sheepCount,dogPos=0,wolfPos;
	Coordinate()
	{
		//generating and assigning random position to sheep, dog and wolf.
		sheepPos=(int) (1+ (Math.random()*23));
		dogPos=(int) (1+ (Math.random()*23));
		wolfPos=(int) (1+ (Math.random()*23)); 
	}

	
}
class Bot
{
	int pos_x,pos_y,point,compass_pos=0;
	
	String[] fcompass={"North", "East", "South", "West"};

	public String compass(int pos)
	{
		return fcompass[pos];
	}

	public String compass()
	{
		return fcompass[compass_pos];
	}

	public String turnR()
	{
		if(compass_pos==3)
		{
			compass_pos=0;
		}
		else
		{
			compass_pos+=1;
		}
		return compass(compass_pos);
	}

	public String turnL()
	{
		if(compass_pos==0)
		{
			compass_pos=3;
		}
		else
		{
			compass_pos-=1;
		}
		return compass(compass_pos);
	}

	public int forward(int point)
	{
		if(fcompass[compass_pos]=="North")
		{
			pos_y+=point;
		}
		else if(fcompass[compass_pos]=="South")
		{
			pos_y-=point;
		}
		else if(fcompass[compass_pos]=="East")
		{
			pos_x+=point;
		}
		else if(fcompass[compass_pos]=="West")
		{
			pos_x-=point;
		}
		return point;
	}

	public void move(String s)
	{
		int count=0;

		for (char ch: s.toCharArray())
		{
			try{
				if(ch=='R')
				{
					this.turnR();
				}
				else if(ch=='L')
				{
					this.turnL();
				}
				else if(ch=='W')
				{
					String move = s.replace("R","").replace("L","");
					String[] fmove = move.split("W");
					count+=1;
					this.forward(Integer.parseInt(fmove[count]));
				}
			}
			catch(Exception exception)
			{
				System.out.print("Error, please check your command.");
				System.exit(0);
			}
		}
	}

	public static void main(String[] args)
	{
		String s = args[0];

		Bot bot = new Bot();

		try{
		bot.move(s);
		}
		catch(Exception exception)
		{
			System.out.print("Error, please check your command.");
			System.exit(0);
		}

		System.out.print("X: "+bot.pos_x+" ");
		System.out.print("Y: "+bot.pos_y+" ");
		System.out.print("Direction: "+bot.compass());
	}
}
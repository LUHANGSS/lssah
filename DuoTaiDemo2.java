abstract class Country
{
	abstract void river();

}

class China extends Country
{
	void river()
	{
		System.out.println("流动");
	}
	void scenery ()
	{
		System.out.println("长城");
	}
}

class America extends Country
{
	void river()
	{
		System.out.println("入海");
	}
	void history()
	{
		System.out.println("白宫");
	}
}

class DuoTaiDemo2 
{
	public static void main(String[] args) 
	{
		
	China c = new China();//创建子类对象
	        c.river();
	        c.scenery();
    America j = new America();
            j.river();
			j.history();
		Country a = new China(); //自动类型提升
		China k = (China)a;//向下转型的目的是为了使用子类中的特有方法。
		k.scenery();//访问子类特有方法
    }
}

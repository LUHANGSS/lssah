abstract class Country
{
	abstract void river();

}

class China extends Country
{
	void river()
	{
		System.out.println("����");
	}
	void scenery ()
	{
		System.out.println("����");
	}
}

class America extends Country
{
	void river()
	{
		System.out.println("�뺣");
	}
	void history()
	{
		System.out.println("�׹�");
	}
}

class DuoTaiDemo2 
{
	public static void main(String[] args) 
	{
		
	China c = new China();//�����������
	        c.river();
	        c.scenery();
    America j = new America();
            j.river();
			j.history();
		Country a = new China(); //�Զ���������
		China k = (China)a;//����ת�͵�Ŀ����Ϊ��ʹ�������е����з�����
		k.scenery();//�����������з���
    }
}

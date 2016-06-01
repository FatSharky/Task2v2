package by.training.task2.entity;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	private List<Kind> kinds;

	public Menu() {
		setKinds(new ArrayList<>());
	}

	public Menu(List<Kind> types) {
		this.setKinds(types);
	}

	public List<Kind> getKinds() {
		return kinds;
	}

	public void setKinds(List<Kind> kinds) {
		this.kinds = kinds;
	}

	public void addKind(Kind kind) {
		this.kinds.add(kind);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kinds == null) ? 0 : kinds.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menu other = (Menu) obj;
		if (kinds == null) {
			if (other.kinds != null)
				return false;
		} else if (!kinds.equals(other.kinds))
			return false;
		return true;
	}

}
